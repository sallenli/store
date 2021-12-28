package com.store.comment.Dao.Impl;

import com.store.comment.Dao.CommentInfoDao;
import com.store.comment.constant.DefaultComment;
import com.store.comment.domain.CommentInfoDo;
import com.store.common.utils.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
@Transactional
/**
 * 评论信息管理模块
 */
public class CommentInfoDaoImplTest {

    @Autowired
    private CommentInfoDao commentInfoDao;

    @Autowired
    DateProvider dateProvider;
    @Test
    public void saveComment() throws Exception{
            CommentInfoDo commentInfoDo = createCommentInfoDo();
        Long id = commentInfoDao.saveComment(commentInfoDo);
        assertNotNull(id);
        assertThat(id,greaterThan(0L));


    }

    private CommentInfoDo createCommentInfoDo() throws Exception{
        CommentInfoDo commentInfoDo = new CommentInfoDo();
        commentInfoDo.setCommentContent("测试评论");
        commentInfoDo.setCommentStatus(DefaultComment.APPROVING);
        commentInfoDo.setCommentType(DefaultComment.GOOD_COMMENT);
        commentInfoDo.setCustomerServiceScore(DefaultComment.COMMENT_SCORE_FIVE);
        commentInfoDo.setDefaultComment(DefaultComment.NO);
        commentInfoDo.setGmtCreate(dateProvider.getCurrentTime());
        commentInfoDo.setGmtModified(dateProvider.getCurrentTime());
        commentInfoDo.setGoodsId(1L);
        commentInfoDo.setGoodsScore(DefaultComment.COMMENT_SCORE_FIVE);
        commentInfoDo.setLogisticsScore(DefaultComment.COMMENT_SCORE_FIVE);
        commentInfoDo.setOrderInfoId(1L);
        commentInfoDo.setOrderItemId(1L);
        commentInfoDo.setShowPictures(DefaultComment.SHOW_PICTURE);
        commentInfoDo.setTotalScore(DefaultComment.COMMENT_SCORE_FIVE);
        commentInfoDo.setUserAccountId(1L);
        commentInfoDo.setUserName("test");
        return  commentInfoDo;
    }
}