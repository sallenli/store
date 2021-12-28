package com.store.wms.domain;


import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 采购入库单DTO
 * @author  sallen
 */

public class PurchaseInputOrderDto {
    private Long id;
    //供应商Id
    private Long suppliedId;
    //预期达到时间
    private Date expectArrivalTime;
    //实际到达时间
    private Date arrivalTime;
    //采购联系人
    private String purchaseContactor;
    //采购联系人电话
    private String purchaseContactPhoneNumber;
    //采购联系人邮件
    private String purchaseContactEmail;
    //采购入库单备注
    private String purchaseInputOrderComment;
    //采购员
    private String purchaser;
    //采购入库单状态
    private String purchaseInputStatus;
    //采购入库单创建时间
    private Date gmtCreate;
    //采购入库单修改时间
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseInputOrderDto that = (PurchaseInputOrderDto) o;
        return Objects.equals(id, that.id) && Objects.equals(suppliedId, that.suppliedId) && Objects.equals(expectArrivalTime, that.expectArrivalTime) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(purchaseContactor, that.purchaseContactor) && Objects.equals(purchaseContactPhoneNumber, that.purchaseContactPhoneNumber) && Objects.equals(purchaseContactEmail, that.purchaseContactEmail) && Objects.equals(purchaseInputOrderComment, that.purchaseInputOrderComment) && Objects.equals(purchaser, that.purchaser) && Objects.equals(purchaseInputStatus, that.purchaseInputStatus) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified) && Objects.equals(purchaseInputOrderItemDtoList, that.purchaseInputOrderItemDtoList) && Objects.equals(PurchaseInputOrderPutOnItemDtOList, that.PurchaseInputOrderPutOnItemDtOList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, suppliedId, expectArrivalTime, arrivalTime, purchaseContactor, purchaseContactPhoneNumber, purchaseContactEmail, purchaseInputOrderComment, purchaser, purchaseInputStatus, gmtCreate, gmtModified, purchaseInputOrderItemDtoList, PurchaseInputOrderPutOnItemDtOList);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSuppliedId() {
        return suppliedId;
    }

    public void setSuppliedId(Long suppliedId) {
        this.suppliedId = suppliedId;
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

    public String getPurchaseInputStatus() {
        return purchaseInputStatus;
    }

    public void setPurchaseInputStatus(String purchaseInputStatus) {
        this.purchaseInputStatus = purchaseInputStatus;
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

    public List<PurchaseInputOrderItemDto> getPurchaseInputOrderItemDtoList() {
        return purchaseInputOrderItemDtoList;
    }

    public void setPurchaseInputOrderItemDtoList(List<PurchaseInputOrderItemDto> purchaseInputOrderItemDtoList) {
        this.purchaseInputOrderItemDtoList = purchaseInputOrderItemDtoList;
    }

    public List<PurchaseInputOrderPutOnItemDtO> getPurchaseInputOrderPutOnItemDtOList() {
        return PurchaseInputOrderPutOnItemDtOList;
    }

    public void setPurchaseInputOrderPutOnItemDtOList(List<PurchaseInputOrderPutOnItemDtO> purchaseInputOrderPutOnItemDtOList) {
        PurchaseInputOrderPutOnItemDtOList = purchaseInputOrderPutOnItemDtOList;
    }

    //树形节点 采购入库单条目集合
    private List<PurchaseInputOrderItemDto> purchaseInputOrderItemDtoList;
    //采购入库单商品上架条目集合
    private List<PurchaseInputOrderPutOnItemDtO> PurchaseInputOrderPutOnItemDtOList;

}
