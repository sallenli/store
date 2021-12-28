package com.store.comment.Dao.Impl;

import com.store.comment.Dao.CommentPictureDao;
import com.store.comment.Mapper.CommentPictureMapper;
import com.store.comment.domain.CommentPictureDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentPictureDaoImpl implements CommentPictureDao {
    private static final Logger logger = LoggerFactory.getLogger(CommentPictureDaoImpl.class);
    @Autowired
    private CommentPictureMapper commentPictureMapper;
    @Override
    public Boolean saveCommentPicture(CommentPictureDo commentPictureDo) {
        try {
            commentPictureMapper.saveCommentPicture(commentPictureDo);
            return true;
        } catch (Exception e) {
            logger.error("CommentPictureDaoImpl.saveCommentPicture",e.getMessage());
            return false;
        }
    }
}
