package com.store.wms.domain;


import java.util.Date;
import java.util.Objects;

/**
 * 销售出库单DTO
 */

public class SalesDeliveryOrderDto {

    private Long id;
    //订单id
    private Long OrderId;
    //订单编号
    private Long OrderNo;
    //用户账号ID
    private Long userAccountId;
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
    //销售出库单状态
    private Integer salesDeliverOrderStatus;
    //实际发货时间
    private Date deliverTime;
    //销售出库单创建时间
    private Date gmtCreated;
    //销售出库单修改时间
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesDeliveryOrderDto that = (SalesDeliveryOrderDto) o;
        return Objects.equals(id, that.id) && Objects.equals(OrderId, that.OrderId) && Objects.equals(OrderNo, that.OrderNo) && Objects.equals(userAccountId, that.userAccountId) && Objects.equals(consignee, that.consignee) && Objects.equals(deliverAddress, that.deliverAddress) && Objects.equals(consigneeCellPhoneNumber, that.consigneeCellPhoneNumber) && Objects.equals(freight, that.freight) && Objects.equals(payType, that.payType) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(discountAmount, that.discountAmount) && Objects.equals(couponAmount, that.couponAmount) && Objects.equals(payableAmount, that.payableAmount) && Objects.equals(invoiceTitle, that.invoiceTitle) && Objects.equals(taxpayerId, that.taxpayerId) && Objects.equals(orderComment, that.orderComment) && Objects.equals(salesDeliverOrderStatus, that.salesDeliverOrderStatus) && Objects.equals(deliverTime, that.deliverTime) && Objects.equals(gmtCreated, that.gmtCreated) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, OrderId, OrderNo, userAccountId, consignee, deliverAddress, consigneeCellPhoneNumber, freight, payType, totalAmount, discountAmount, couponAmount, payableAmount, invoiceTitle, taxpayerId, orderComment, salesDeliverOrderStatus, deliverTime, gmtCreated, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public Long getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(Long orderNo) {
        OrderNo = orderNo;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
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

    public Integer getSalesDeliverOrderStatus() {
        return salesDeliverOrderStatus;
    }

    public void setSalesDeliverOrderStatus(Integer salesDeliverOrderStatus) {
        this.salesDeliverOrderStatus = salesDeliverOrderStatus;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
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
}
