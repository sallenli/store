package com.store.promotion.domain;

import java.util.Date;

/**
 * 促销活动dto
 */
public class PromotionActivityDto {
    //id
    private Long id;
    //促销活动名称
    private String PromotionActivityName;
    //促销活动开始时间
    private String PromotionActivityStartTime;
    //促销活动结束时间
    private String PromotionActivityEndTime;
    //促销活动备注
    private String PromotionActivityComment;
    //促销活动状态
    private Integer PromotionActivityStatus;
    //促销活动规则
    private String PromotionActivityRule;
    //促销活动创建时间
    private Date gmtCreate;
        //促销活动修改时间
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromotionActivityName() {
        return PromotionActivityName;
    }

    public void setPromotionActivityName(String promotionActivityName) {
        PromotionActivityName = promotionActivityName;
    }

    public String getPromotionActivityStartTime() {
        return PromotionActivityStartTime;
    }

    public void setPromotionActivityStartTime(String promotionActivityStartTime) {
        PromotionActivityStartTime = promotionActivityStartTime;
    }

    public String getPromotionActivityEndTime() {
        return PromotionActivityEndTime;
    }

    public void setPromotionActivityEndTime(String promotionActivityEndTime) {
        PromotionActivityEndTime = promotionActivityEndTime;
    }

    public String getPromotionActivityComment() {
        return PromotionActivityComment;
    }

    public void setPromotionActivityComment(String promotionActivityComment) {
        PromotionActivityComment = promotionActivityComment;
    }

    public Integer getPromotionActivityStatus() {
        return PromotionActivityStatus;
    }

    public void setPromotionActivityStatus(Integer promotionActivityStatus) {
        PromotionActivityStatus = promotionActivityStatus;
    }

    public String getPromotionActivityRule() {
        return PromotionActivityRule;
    }

    public void setPromotionActivityRule(String promotionActivityRule) {
        PromotionActivityRule = promotionActivityRule;
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
