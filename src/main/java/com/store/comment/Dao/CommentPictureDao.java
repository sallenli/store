package com.store.comment.Dao;

import com.store.comment.domain.CommentPictureDo;

/**
 * 图片处理Dao
 */
public interface CommentPictureDao {
    /**
     * 新增保存图片
     * @param commentPictureDo 图片do
     */
    Boolean saveCommentPicture(CommentPictureDo commentPictureDo);
}
