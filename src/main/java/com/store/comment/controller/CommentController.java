package com.store.comment.controller;




import com.store.comment.constant.DefaultComment;
import com.store.comment.domain.CommentInfoDto;
import com.store.comment.domain.CommentInfoVo;
import com.store.comment.service.CommentAggregateService;
import com.store.comment.service.CommentInfoService;
import com.store.comment.service.CommentPictureService;
import com.store.membership.service.MembershipFacadeService;
import com.store.order.service.OrderFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论中心controller层组件
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentInfoService commentInfoService;
    @Autowired
    private CommentPictureService commentPictureService;
    /**
     * 评论统计信息service组件
     */
    @Autowired
    private CommentAggregateService commentAggregateService;
    /**
     * 订单接口
     */
    @Autowired
    private OrderFacadeService orderFacadeService;

    @Autowired
    private MembershipFacadeService membershipFacadeService;
    /**
     * 手动发表评论
     * @param commentInfoVo 评论信息vo
     * @return 处理结果
     */
    @PostMapping("/")
    public Boolean PublishComment(HttpServletRequest request,CommentInfoVo commentInfoVo, MultipartFile [] files){
            try {
                //对图片的处理
                Integer showPicture = DefaultComment.NOT_SHOW_PICTURE;
                if(files != null && files.length > 0){
                    for (MultipartFile file: files) {
                        if(file != null){
                            showPicture = DefaultComment.SHOW_PICTURE;
                            break;
                        }
                    }
                }
                commentInfoVo.setShowPictures(showPicture);
                //保存评论信息
                CommentInfoDto commentInfoDto = commentInfoVo.clone(CommentInfoDto.class);
                 commentInfoService.saveManualPublishComment(commentInfoDto);
                //获取当前url路径
                String appBasePath = request.getSession().getServletContext().getRealPath("/");
                //commentInfo.id 通过do传回
                commentPictureService.saveCommentPicture(appBasePath,commentInfoDto.getId(),files);
                //评论统计信息更新
                commentAggregateService.updateCommentAggregate(commentInfoDto);
                //通知订单中心，用户发表评论
                orderFacadeService.informPublishCommentEvent(commentInfoDto.getOrderInfoId());
                //通知会员中心，用户已经发表评论
                membershipFacadeService.informPublishCommentEvent(commentInfoDto.getUserAccountId(),DefaultComment.SHOW_PICTURE.equals(showPicture));
                return true;
            }
            catch (Exception e){
                    logger.error("CommentController.PublishComment",e.getMessage());
                    return  false;
            }
    }
}
