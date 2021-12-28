package com.store.comment.Dao;

import com.store.comment.domain.CommentInfoDo;

/**
 * 评论信息dao
 */
public interface CommentInfoDao {
    /**
     * 新增评论信息
     * @param CommentInfoDo
     * @return
     */
    Long saveComment(CommentInfoDo CommentInfoDo);
}
