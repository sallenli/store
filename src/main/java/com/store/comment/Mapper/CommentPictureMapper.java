package com.store.comment.Mapper;

import com.store.comment.domain.CommentPictureDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * 图片处理mapper
 */
@Mapper
public interface CommentPictureMapper {
    /**
     * 新增保存图片
     * @param commentPictureDo 图片do
     */
    @Insert("insert into "
            +"comment_picture"
            +"(comment_info_id,"
            +"comment_picture_path" +
            "gmt_create" +
            "gmt_modified)"+
                "values("+
            "#{commentInfoId}"+
            "#{commentPicturePath}"+
            "#{gmtCreate}"+
            "#{gmtModified}"+
                ")")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveCommentPicture(CommentPictureDo commentPictureDo);
}
