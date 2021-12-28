package com.store.wms.domain;



import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 退货入库单dto
 */

public class ReturnGoodsInputOrderDto {
    private Long id;
        //用户账号id
    private Long userAccountId;
        //订单id
    private Long orderId;
    //订单编号
    private String oderNo;
    //退货入库单的状态
        private Integer returnGoodsInputOrderStatus;
    //收货人
    private String consignee;
    //收货地址
    private String deliverAddress;
    //收货人电话
    private String consigneeCellPhoneNumber;
    //运费
    private Double freight;
        //支付方式
    private Integer payType;
    //订单总金额
    private Double totalAmount;
    //折扣金额
    private Double discountAmount;
    //优惠券抵扣金额
    private Double couponAmount;
        //应付金额
    private Double payableAmount;
        //发票抬头
    private String invoiceTitle;
    //纳税人识别号
    private String taxpayerId;
        //订单备注
    private String orderComment;
    //退货原因
    private String returnGoodsReason;
    //退货备注
    private String returnGoodsComment;
    //退货实际到货时间
    private Date arrivalTime;
    //退货单创建时间
    private Date gmtCreated;
    //退货单修改时间
    private Date gmtModified;
    //退货入库单商品条目dto
    private List<ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtoList;
    //退货入库单商品上架条目dto
    private List<ReturnGoodsInputOrderPutOnItemDto> returnGoodsInputOrderPutOnItemDtoList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnGoodsInputOrderDto that = (ReturnGoodsInputOrderDto) o;
        return Objects.equals(id, that.id) && Objects.equals(userAccountId, that.userAccountId) && Objects.equals(orderId, that.orderId) && Objects.equals(oderNo, that.oderNo) && Objects.equals(returnGoodsInputOrderStatus, that.returnGoodsInputOrderStatus) && Objects.equals(consignee, that.consignee) && Objects.equals(deliverAddress, that.deliverAddress) && Objects.equals(consigneeCellPhoneNumber, that.consigneeCellPhoneNumber) && Objects.equals(freight, that.freight) && Objects.equals(payType, that.payType) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(discountAmount, that.discountAmount) && Objects.equals(couponAmount, that.couponAmount) && Objects.equals(payableAmount, that.payableAmount) && Objects.equals(invoiceTitle, that.invoiceTitle) && Objects.equals(taxpayerId, that.taxpayerId) && Objects.equals(orderComment, that.orderComment) && Objects.equals(returnGoodsReason, that.returnGoodsReason) && Objects.equals(returnGoodsComment, that.returnGoodsComment) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(gmtCreated, that.gmtCreated) && Objects.equals(gmtModified, that.gmtModified) && Objects.equals(returnGoodsInputOrderItemDtoList, that.returnGoodsInputOrderItemDtoList) && Objects.equals(returnGoodsInputOrderPutOnItemDtoList, that.returnGoodsInputOrderPutOnItemDtoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAccountId, orderId, oderNo, returnGoodsInputOrderStatus, consignee, deliverAddress, consigneeCellPhoneNumber, freight, payType, totalAmount, discountAmount, couponAmount, payableAmount, invoiceTitle, taxpayerId, orderComment, returnGoodsReason, returnGoodsComment, arrivalTime, gmtCreated, gmtModified, returnGoodsInputOrderItemDtoList, returnGoodsInputOrderPutOnItemDtoList);
    }

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOderNo() {
        return oderNo;
    }

    public void setOderNo(String oderNo) {
        this.oderNo = oderNo;
    }

    public Integer getReturnGoodsInputOrderStatus() {
        return returnGoodsInputOrderStatus;
    }

    public void setReturnGoodsInputOrderStatus(Integer returnGoodsInputOrderStatus) {
        this.returnGoodsInputOrderStatus = returnGoodsInputOrderStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getConsigneeCellPhoneNumber() {
        return consigneeCellPhoneNumber;
    }

    public void setConsigneeCellPhoneNumber(String consigneeCellPhoneNumber) {
        this.consigneeCellPhoneNumber = consigneeCellPhoneNumber;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getReturnGoodsReason() {
        return returnGoodsReason;
    }

    public void setReturnGoodsReason(String returnGoodsReason) {
        this.returnGoodsReason = returnGoodsReason;
    }

    public String getReturnGoodsComment() {
        return returnGoodsComment;
    }

    public void setReturnGoodsComment(String returnGoodsComment) {
        this.returnGoodsComment = returnGoodsComment;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public List<ReturnGoodsInputOrderItemDto> getReturnGoodsInputOrderItemDtoList() {
        return returnGoodsInputOrderItemDtoList;
    }

    public void setReturnGoodsInputOrderItemDtoList(List<ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtoList) {
        this.returnGoodsInputOrderItemDtoList = returnGoodsInputOrderItemDtoList;
    }

    public List<ReturnGoodsInputOrderPutOnItemDto> getReturnGoodsInputOrderPutOnItemDtoList() {
        return returnGoodsInputOrderPutOnItemDtoList;
    }

    public void setReturnGoodsInputOrderPutOnItemDtoList(List<ReturnGoodsInputOrderPutOnItemDto> returnGoodsInputOrderPutOnItemDtoList) {
        this.returnGoodsInputOrderPutOnItemDtoList = returnGoodsInputOrderPutOnItemDtoList;
    }
}

