package com.store.comment.service;

import com.store.comment.domain.CommentPictureDo;
import com.store.comment.domain.CommentPictureDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * 评论晒图service
 */
public interface CommentPictureService {


    /**
     * 添加评论图片
     * @param appBasePath  当前应用根路径
     * @param commentInfoId 评论id
     * @param files 上传的图片
     * @return
     */
    Boolean saveCommentPicture(String appBasePath,Long commentInfoId, MultipartFile[] files);
}
