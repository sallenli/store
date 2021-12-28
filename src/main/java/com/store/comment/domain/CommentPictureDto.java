package com.store.comment.domain;

import com.store.common.utils.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 评论晒图dto
 */
public class CommentPictureDto {

    private static final Logger logger = LoggerFactory.getLogger(CommentPictureDto.class);
    //主键id
    private Long id;
    //评论id
    private long  commentInfoId;
    //晒图图片路径
    private String commentPicturePath;
    //创建时间
    private Date gmtCreate;
    //时间
    private  Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCommentInfoId() {
        return commentInfoId;
    }

    public void setCommentInfoId(long commentInfoId) {
        this.commentInfoId = commentInfoId;
    }

    public String getCommentPicturePath() {
        return commentPicturePath;
    }

    public void setCommentPicturePath(String commentPicturePath) {
        this.commentPicturePath = commentPicturePath;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public <T> T clone(Class<T> clz){
        T target = null;
        try {
            target = clz.newInstance();
            BeanCopierUtils.copyProperties(this,target);
            return target;
        } catch (Exception e) {
            logger.error("CommentPictureDto.clone",e.getMessage());
            return  null;
        }
    }
}
