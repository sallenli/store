package com.store.comment.service;

import com.store.comment.domain.CommentInfoDto;
import com.store.order.domain.OrderInfoDto;
import com.store.order.domain.OrderItemDto;

/**
 * 评论信息service
 */
public interface CommentInfoService {
    /**
     * 新增手动评论
     * @param commentInfoDto
     * @return
     */
    Boolean saveManualPublishComment(CommentInfoDto commentInfoDto);

    /**
     * 新增自动评论

     * @return
     */
    CommentInfoDto saveAutoPublishCommentInfo(OrderInfoDto orderInfoDto,
                                              OrderItemDto orderItemDto);
}
