package com.store.comment.Dao.Impl;

import com.store.comment.Dao.CommentInfoDao;
import com.store.comment.Mapper.CommentInfoMapper;
import com.store.comment.domain.CommentInfoDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 评论信息impl
 */
@Repository
public class CommentInfoDaoImpl implements CommentInfoDao {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoDaoImpl.class);
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    @Override
    public Long saveComment(CommentInfoDo commentInfoDo) {
        try {

            commentInfoMapper.saveComment(commentInfoDo);
            return  commentInfoDo.getId();
        } catch (Exception e) {
            logger.error("CommentInfoDaoImpl.saveComment",e.getMessage());
            return  null;
        }
    }
}
