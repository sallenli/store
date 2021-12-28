package com.store.comment.service.impl;

import com.store.comment.Dao.CommentInfoDao;
import com.store.comment.constant.DefaultComment;
import com.store.comment.domain.CommentInfoDo;
import com.store.comment.domain.CommentInfoDto;
import com.store.comment.service.CommentInfoService;
import com.store.common.utils.DateProvider;
import com.store.order.domain.OrderInfoDto;
import com.store.order.domain.OrderItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 评论信息service
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoServiceImpl.class);
    @Autowired
    private CommentInfoDao commentInfoDao;
    @Autowired
    private DateProvider dateProvider;
    @Override
    public Boolean saveManualPublishComment(CommentInfoDto commentInfoDto) {
        try {
            //计算评论分数
            Integer totalScore = Math.round((commentInfoDto.getGoodsScore()+commentInfoDto.getCustomerServiceScore()+commentInfoDto.getLogisticsScore())/3);
            commentInfoDto.setTotalScore(totalScore);
            //设置是否为默认评论
            commentInfoDto.setCommentType(DefaultComment.NO);
            //设置评论状态
            commentInfoDto.setCommentStatus(DefaultComment.APPROVING);

            //设置评论类型 (好中差)
            Integer commentType = 0 ;

            if(totalScore >= 4){
                commentType = DefaultComment.GOOD_COMMENT;
            }
           else if (totalScore == 3){
                commentType = DefaultComment.MEDIUM_COMMENT;
            }
            else if (totalScore >=0 && totalScore <= 2){
                commentType = DefaultComment.BAD_COMMENT;
            }
            else {
                commentType = DefaultComment.ERROR_COMMENT;
            }
            commentInfoDto.setCommentType(commentType);
            commentInfoDto.setGmtCreate(dateProvider.getCurrentTime());
            commentInfoDto.setGmtModified(dateProvider.getCurrentTime());
            //将评论信息保存到数据库
            CommentInfoDo commentInfoDo = commentInfoDto.clone(CommentInfoDo.class);
            commentInfoDao.saveComment(commentInfoDo);
            //保存到数据库以后，id返回在对应的do中
            commentInfoDto.setId(commentInfoDo.getId());
            return true;
        } catch (Exception e) {
            logger.error("CommentInfoServiceImpl.saveComment",e.getMessage());
            return false;
        }

    }

    @Override
    public CommentInfoDto saveAutoPublishCommentInfo(OrderInfoDto orderInfoDto,
                                                     OrderItemDto orderItemDto) {
        try {
            CommentInfoDto commentInfoDto = createCommentInfoDto(orderInfoDto, orderItemDto);
            //将评论信息保存到数据库
            CommentInfoDo commentInfoDo = commentInfoDto.clone(CommentInfoDo.class);
            commentInfoDao.saveComment(commentInfoDo);
            //保存到数据库以后，id返回在对应的do中
            commentInfoDto.setId(commentInfoDo.getId());
            return commentInfoDto;
        } catch (Exception e) {
            logger.error("CommentInfoServiceImpl.saveComment",e.getMessage());
            return null;
        }
    }

    /**
     * 创建评论信息dto对象
     * @param orderInfoDto 订单信息dto对象
     * @param orderItemDto 订单条目dto对象
     * @return
     */
    public CommentInfoDto createCommentInfoDto(OrderInfoDto orderInfoDto,
                                                OrderItemDto orderItemDto){
        try {
            CommentInfoDto commentInfoDto = new CommentInfoDto();
            commentInfoDto.setUserAccountId(orderInfoDto.getUserAccountId());
            commentInfoDto.setUserName(orderInfoDto.getUserName());
            commentInfoDto.setOrderInfoId(orderInfoDto.getId());
            commentInfoDto.setOrderItemId(orderItemDto.getId());
            commentInfoDto.setGoodsId(orderItemDto.getGoodsId());
            commentInfoDto.setGoodsSkuId(orderItemDto.getGoodsSkuId());
            commentInfoDto.setGoodsSkuSaleProperties(orderItemDto.getSaleProperties());
            commentInfoDto.setTotalScore(DefaultComment.COMMENT_SCORE_FIVE);
            commentInfoDto.setGoodsScore(DefaultComment.COMMENT_SCORE_FIVE);
            commentInfoDto.setCustomerServiceScore(DefaultComment.COMMENT_SCORE_FIVE);
            commentInfoDto.setLogisticsScore(DefaultComment.COMMENT_SCORE_FIVE);
            commentInfoDto.setCommentContent(DefaultComment.COMMENT_CONTENT_DEFAULT);
            //设置是否为默认评论
            commentInfoDto.setCommentType(DefaultComment.YES);
            //设置是否晒图
            commentInfoDto.setShowPictures(DefaultComment.NOT_SHOW_PICTURE);
            //设置评论状态
            commentInfoDto.setCommentStatus(DefaultComment.APPROVED);
            //设置评论类型 (好中差)
            commentInfoDto.setCommentType(DefaultComment.GOOD_COMMENT);
            commentInfoDto.setGmtCreate(new Date());
            commentInfoDto.setGmtModified(new Date());
            return commentInfoDto;
        } catch (Exception e) {
            logger.error("CommentInfoServiceImpl.createCommmentInfoDto",e.getMessage());
            return null;
        }
    }
}
