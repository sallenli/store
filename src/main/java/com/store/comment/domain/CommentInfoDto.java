package com.store.comment.domain;

import com.store.common.utils.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Date;

public class CommentInfoDto {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getGoodsSkuSaleProperties() {
        return goodsSkuSaleProperties;
    }

    public void setGoodsSkuSaleProperties(String goodsSkuSaleProperties) {
        this.goodsSkuSaleProperties = goodsSkuSaleProperties;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(Integer goodsScore) {
        this.goodsScore = goodsScore;
    }

    public Integer getCustomerServiceScore() {
        return customerServiceScore;
    }

    public void setCustomerServiceScore(Integer customerServiceScore) {
        this.customerServiceScore = customerServiceScore;
    }

    public Integer getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(Integer logisticsScore) {
        this.logisticsScore = logisticsScore;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getShowPictures() {
        return showPictures;
    }

    public void setShowPictures(Integer showPictures) {
        this.showPictures = showPictures;
    }

    public Integer getDefaultComment() {
        return defaultComment;
    }

    public void setDefaultComment(Integer defaultComment) {
        this.defaultComment = defaultComment;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
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
            target= clz.newInstance();
            BeanCopierUtils.copyProperties(this,target);
            return target;
        } catch (Exception e) {
            logger.error("CommentInfoDto.clone",e.getMessage());
            return null;
        }


    }
}
