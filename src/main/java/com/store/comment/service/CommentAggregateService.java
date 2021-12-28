package com.store.comment.service;

import com.store.comment.domain.CommentAggregateDo;
import com.store.comment.domain.CommentInfoDto;

/**
 * 评论统计信息 service接口
 */
public interface CommentAggregateService {


    /**
     * 更新评论统计信息
     * @param commentInfoDto 评论信息dto
     */

    Boolean updateCommentAggregate(CommentInfoDto commentInfoDto);
}
