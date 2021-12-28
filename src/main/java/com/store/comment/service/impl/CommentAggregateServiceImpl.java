package com.store.comment.service.impl;

import com.store.comment.Dao.CommentAggregateDao;
import com.store.comment.constant.DefaultComment;
import com.store.comment.domain.CommentAggregateDo;
import com.store.comment.domain.CommentInfoDto;
import com.store.comment.service.CommentAggregateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
@Service
public class CommentAggregateServiceImpl implements CommentAggregateService {

    private static final Logger logger = LoggerFactory.getLogger(CommentAggregateServiceImpl.class);
    @Autowired
    private CommentAggregateDao commentAggregateDao;

    /**
     * 更新评论统计信息
     * @param commentInfoDto 评论信息dto
     * @return
     */
    @Override
    public Boolean updateCommentAggregate(CommentInfoDto commentInfoDto) {
        /**
         * 评论统计信息do
         */
        try {

            CommentAggregateDo commentAggregate = commentAggregateDao.getCommentAggregateByGoodsId(commentInfoDto.getGoodsId());
            //第一次评论,添加商品评论信息
            if (commentAggregate == null) {
                commentAggregate = new CommentAggregateDo();
                commentAggregate.setGoodsId(commentInfoDto.getGoodsId());
                commentAggregate.setTotalCommentCount(1L);
                if (commentInfoDto.getCommentType().equals(DefaultComment.GOOD_COMMENT)) {
                    commentAggregate.setGoodCommentCount(1L);
                } else if (commentInfoDto.getCommentType().equals(DefaultComment.MEDIUM_COMMENT)) {
                    commentAggregate.setMediumCommentCount(1L);
                } else {
                    commentAggregate.setBadCommentCount(1L);
                }
                //好评率
                Double GoodCommentRate = Double.valueOf(
                        new DecimalFormat("#.00").format(commentAggregate.getGoodCommentRate() / commentAggregate.getTotalCommentCount()));
                commentAggregate.setGoodCommentRate(GoodCommentRate);
                //如果有图
                if (DefaultComment.SHOW_PICTURE.equals(commentInfoDto.getShowPictures())) {
                    commentAggregate.setShowPicturesComment(1L);
                }
                commentAggregate.setGmtCreate(new Date());
                commentAggregate.setGmtModified(new Date());
            }
            //如果商品id已有对应的评论信息
            else {
                commentAggregate.setGoodsId(commentInfoDto.getGoodsId());
                commentAggregate.setTotalCommentCount(commentAggregate.getTotalCommentCount() + 1L);
                if (commentInfoDto.getCommentType().equals(DefaultComment.GOOD_COMMENT)) {
                    commentAggregate.setGoodCommentCount(commentAggregate.getGoodCommentCount() + 1L);
                } else if (commentInfoDto.getCommentType().equals(DefaultComment.MEDIUM_COMMENT)) {
                    commentAggregate.setMediumCommentCount(commentAggregate.getMediumCommentCount() + 1L);
                } else {
                    commentAggregate.setBadCommentCount(commentAggregate.getBadCommentCount() + 1L);
                }
                //好评率
                Double GoodCommentRate = Double.valueOf(
                        new DecimalFormat("#.00").format(commentAggregate.getGoodCommentRate() / commentAggregate.getTotalCommentCount()));
                commentAggregate.setGoodCommentRate(GoodCommentRate);
                //如果有图
                if (DefaultComment.SHOW_PICTURE.equals(commentInfoDto.getShowPictures())) {
                    commentAggregate.setShowPicturesComment(commentAggregate.getShowPicturesComment() + 1L);
                }

                commentAggregate.setGmtModified(new Date());
            }

            return true;
        }
        catch (Exception e){
            logger.error("CommentAggregateServiceImpl.updateCommentAggregate",e.getMessage());
            return  false;
        }

    }


}
