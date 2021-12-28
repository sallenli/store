package com.store.comment.Mapper;

import com.store.comment.domain.CommentInfoDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * 评论信息mapper
 */
@Mapper
public interface CommentInfoMapper {

    /**
     * 新增评论信息
     * @param CommentInfoDo
     */
    @Insert("insert into " +
            "comment_info ( " +
            "user_account_id,"+
            "user_name,"+
            "order_info_id,"+
            "order_item_id,"+
            "goods_id,"+
            "goods_sku_id,"+
            "goods_sku_sale_properties,"+
            "total_score,"+
            "goods_score,"+
            "customer_service_score,"+
            "logistics_score,"+
            "comment_content,"+
            "is_show_pictures,"+
            "is_default_comment,"+
            "comment_status,"+
            "comment_type,"+
            "gmt_create,"+
            "gmt_modified) "+
            "values (" +
            "#{userAccountId},"+
            "#{userName},"+
            "#{orderInfoId},"+
            "#{orderItemId},"+
            "#{goodsId},"+
            "#{goodsSkuId},"+
            "#{goodsSkuSaleProperties},"+
            "#{totalScore},"+
            "#{goodsScore},"+
            "#{customerServiceScore},"+
            "#{logisticsScore},"+
            "#{commentContent},"+
            "#{commentType},"+
            "#{showPictures},"+
            "#{defaultComment},"+
            "#{gmtCreate},"+
            "#{gmtModified})"
            )
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveComment(CommentInfoDo CommentInfoDo);
}
