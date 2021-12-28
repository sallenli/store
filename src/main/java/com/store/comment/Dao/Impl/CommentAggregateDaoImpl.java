package com.store.comment.Dao.Impl;

import com.store.comment.Dao.CommentAggregateDao;
import com.store.comment.Dao.CommentInfoDao;
import com.store.comment.Mapper.CommentAggregateMapper;
import com.store.comment.domain.CommentAggregateDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentAggregateDaoImpl implements CommentAggregateDao {

    private static final Logger logger = LoggerFactory.getLogger(CommentAggregateDaoImpl.class);
    @Autowired
    CommentAggregateMapper commentAggregateMapper;
    @Override
    public CommentAggregateDo getCommentAggregateByGoodsId(Long goodsId) {
        try {
            return commentAggregateMapper.getCommentAggregateByGoodsId(goodsId);
        } catch (Exception e) {
            logger.error("CommentAggregateDaoImpl.getCommentAggregateByGoodsId",e.getMessage());
                return null;
        }
    }

    @Override
    public Boolean saveCommentAggregate(CommentAggregateDo commentAggregateDo) {
        try {
            commentAggregateMapper.saveCommentAggregate(commentAggregateDo);
            return true;
        } catch (Exception e) {
            logger.error("CommentAggregateDaoImpl.saveCommentAggregate",e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean updateCommentAggregate(CommentAggregateDo commentAggregateDo) {
        try {
             commentAggregateMapper.updateCommentAggregate(commentAggregateDo);
            return true;
        } catch (Exception e) {
            logger.error("CommentAggregateDaoImpl.updateCommentAggregate",e.getMessage());
            return false;
        }
    }
}
