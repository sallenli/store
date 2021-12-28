package com.store.comment.Mapper;

import com.store.comment.domain.CommentAggregateDo;
import org.apache.ibatis.annotations.*;

/**
 *评论统计信息mapper组件
 */
@Mapper
public interface CommentAggregateMapper {
    /**
     * 根据商品id查询评论统计信息
     * @param goodsId 商品id
     * @return 评论统计信息
     */
    @Select("select" +
            "id,"+
            "goods_id,"+
            "total_comment_count"+
            "good_comment_count"+
            "good_comment_rate"+
            "show_pictures_comment"+
            "medium_comment_count"+
            "bad_comment_count"+
            "gmt_create"+
            "gmt_modified"+
            "from comment_aggregate"+
            "where"+
            "goods_id = #{goodsId}"
    )
      @Results({@Result(column =  "id", property = "id" ,id =true),
              @Result(column = "goods_id", property = "goodsId"),
              @Result(column = "total_comment_count", property = "totalCommentCount"),
              @Result(column = "good_comment_rate", property = "goodCommentRate"),
              @Result(column = "show_pictures_comment", property = "showPicturesComment"),
              @Result(column = "medium_comment_count", property = "mediumCommentCount"),
              @Result(column = "bad_comment_count", property = "badCommentCount"),
              @Result(column = "gmt_create", property = "gmtCreate"),
              @Result(column = "gmt_modified", property = "gmtModified"),
      })
    CommentAggregateDo getCommentAggregateByGoodsId(@Param("goodsId") Long goodsId);

    /**
     * 新增评论信息
     * @param commentAggregateDo 评论统计信息do对象
     */
    @Insert("insert into" +
            "comment_aggregate" +
            "(" +
            "goods_id," +
            "total_comment_count," +
            "good_comment_count," +
            "good_comment_rate," +
            "show_pictures_comment," +
            "medium_comment_count," +
            "bad_comment_count," +
            "gmt_create," +
            "gmt_modified)" +
            "values(" +
            "#{goodsId}," +
            "#{totalCommentCount}," +
            "#{goodCommentCount}," +
            "#{goodCommentRate}," +
            "#{showPicturesComment}," +
            "#{mediumCommentCount}," +
            "#{badCommentCount}," +
            "#{gmtCreate}," +
            "#{gmtModified})")
    void saveCommentAggregate(CommentAggregateDo commentAggregateDo);

    /**
     * 更新评论统计信息
     * @param commentAggregateDo
     */
    @Update("update comment_aggregate" +
            "set" +
            "goods_id =#{goodsId}," +
            "total_comment_count= #{totalCommentCount}," +
            "good_comment_count = #{goodCommentCount}" +
            "good_comment_rate = #{goodCommentRate}" +
            "show_pictures_comment = #{showPicturesComment}" +
            "medium_comment_count = #{mediumCommentCount}" +
            "bad_comment_count = #{badCommentCount}" +
            "gmt_modified = #{gmtModified}"+
            "where id = #{id}"
    )
    void updateCommentAggregate(CommentAggregateDo commentAggregateDo);
}
