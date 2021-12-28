package com.store.purchase.domain;

import java.util.Date;

/**
 * 采购单dto
 */
public class PurchaseOrderDto {

    private  Long id;
    //供应商id
    private Long supplierId;
    //预期到货时间
    private Date expectArrivalTime;
    //实际到达时间
    private Date arrivalTime;
    //采购联系人
    private String purchaseContactor;
    //采购联系人电话
    private String purchaseContactPhoneNumber;
    //采购联系人邮件
    private String purchaseContactEmail;
        //采购单备注
    private String purchaseInputOrderComment;
    //采购员
    private String purchaser;
    //采购单状态
    private String purchaseOrderStatus;
    //采购单创建时间
        private Date gmtCreate;
    //采购单修改时间
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getExpectArrivalTime() {
        return expectArrivalTime;
    }

    public void setExpectArrivalTime(Date expectArrivalTime) {
        this.expectArrivalTime = expectArrivalTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getPurchaseContactor() {
        return purchaseContactor;
    }

    public void setPurchaseContactor(String purchaseContactor) {
        this.purchaseContactor = purchaseContactor;
    }

    public String getPurchaseContactPhoneNumber() {
        return purchaseContactPhoneNumber;
    }

    public void setPurchaseContactPhoneNumber(String purchaseContactPhoneNumber) {
        this.purchaseContactPhoneNumber = purchaseContactPhoneNumber;
    }

    public String getPurchaseContactEmail() {
        return purchaseContactEmail;
    }

    public void setPurchaseContactEmail(String purchaseContactEmail) {
        this.purchaseContactEmail = purchaseContactEmail;
    }

    public String getPurchaseInputOrderComment() {
        return purchaseInputOrderComment;
    }

    public void setPurchaseInputOrderComment(String purchaseInputOrderComment) {
        this.purchaseInputOrderComment = purchaseInputOrderComment;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(String purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
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
