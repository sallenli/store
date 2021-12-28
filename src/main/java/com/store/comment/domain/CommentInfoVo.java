package com.store.comment.domain;

import com.store.common.utils.BeanCopierUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Data
public class CommentInfoVo {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoDto.class);
    //主键id
    private Long id;
    //发表评论的用户账号
    private Long userAccountId;
    //用户名
    private String userName;
    //订单编号id
    private Long orderInfoId;
    //订单条目id
    private Long orderItemId;
    //订单条目对应商品id
    private Long goodsId;
    //商品skuId
    private Long goodsSkuId;
    //商品sku销售属性
    private String goodsSkuSaleProperties;
    //总评分（1~5）
    private Integer  totalScore;
    //商品评价分（1~5）
    private Integer  goodsScore;
    //客服评分（1~5）
    private Integer  customerServiceScore;
    //物流评分（1~5）
    private Integer  logisticsScore;
    //评分内容
    private String  commentContent;
    //是否晒图
    private Integer  showPictures;
    //是否是系统默认评价
    private Integer  defaultComment;
    //评论状态1.待审核 2已审核
    private Integer  commentStatus;
    //评论类型 1.好评 2中评3差评
    private Integer  commentType;
    //评价创建时间
    private Date gmtCreate;
    //评价修改时间
    private Date  gmtModified;


    public <T> T clone(Class<T> clz){
        T target = null;
        try {
            target= clz.newInstance();
            BeanCopierUtils.copyProperties(this,target);
            return target;
        } catch (Exception e) {
            logger.error("CommentInfoVo.clone",e.getMessage());
            return null;
        }


    }
}
