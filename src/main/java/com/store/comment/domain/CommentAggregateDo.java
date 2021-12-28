package com.store.comment.domain;

import java.util.Date;

/**
 * 评论统计聚合信息
 */
public class CommentAggregateDo {
    /**
     * id
     */
    private Long id;
    //商品id
    private Long goodsId;
    //评论总数量
    private Long totalCommentCount;
    //好评数量
    private Long goodCommentCount;
    //好评率
    private Double goodCommentRate;
    //晒图评论数量
    private Long showPicturesComment;
    //中评数量
    private Long mediumCommentCount;
    //差评数量
    private Long badCommentCount;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getTotalCommentCount() {
        return totalCommentCount;
    }

    public void setTotalCommentCount(Long totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    public Long getGoodCommentCount() {
        return goodCommentCount;
    }

    public void setGoodCommentCount(Long goodCommentCount) {
        this.goodCommentCount = goodCommentCount;
    }

    public Double getGoodCommentRate() {
        return goodCommentRate;
    }

    public void setGoodCommentRate(Double goodCommentRate) {
        this.goodCommentRate = goodCommentRate;
    }

    public Long getShowPicturesComment() {
        return showPicturesComment;
    }

    public void setShowPicturesComment(Long showPicturesComment) {
        this.showPicturesComment = showPicturesComment;
    }

    public Long getMediumCommentCount() {
        return mediumCommentCount;
    }

    public void setMediumCommentCount(Long mediumCommentCount) {
        this.mediumCommentCount = mediumCommentCount;
    }

    public Long getBadCommentCount() {
        return badCommentCount;
    }

    public void setBadCommentCount(Long badCommentCount) {
        this.badCommentCount = badCommentCount;
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
}
