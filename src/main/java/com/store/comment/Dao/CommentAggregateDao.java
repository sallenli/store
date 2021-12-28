package com.store.comment.Dao;

import com.store.comment.domain.CommentAggregateDo;
import org.apache.ibatis.annotations.*;

/**
 * 评论统计信息dao
 */
public interface CommentAggregateDao {
    /**
     * 根据商品id查询评论统计信息
     * @param goodsId 商品id
     * @return 评论统计信息
     */

    CommentAggregateDo getCommentAggregateByGoodsId( Long goodsId);

    /**
     * 新增评论信息
     * @param commentAggregateDo 评论统计信息do对象
     */

    Boolean saveCommentAggregate(CommentAggregateDo commentAggregateDo);

    /**
     * 更新评论统计信息
     * @param commentAggregateDo
     */

    Boolean updateCommentAggregate(CommentAggregateDo commentAggregateDo);
}
