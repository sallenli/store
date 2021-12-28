package com.store.order.domain;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 订单dto
 */

public class OrderInfoDto {

    private Long id;
    //用户id
    private Long userAccountId;
    //用户名
    private String userName;
    //订单编号
    private Long orderNo;
    //订单状态
   private Integer orderStatus;
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
    //订单创建时间
    private Date gmtCreated;
    //订单修改时间
    private Date gmtModified;
    //是否发表评论
    private Integer publishedComment;
    //确认收货时间
    private Date confirmReceiptTime;
    //订单条目dto列表
    private List<OrderItemDto> orderItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfoDto that = (OrderInfoDto) o;
        return Objects.equals(id, that.id) && Objects.equals(userAccountId, that.userAccountId) && Objects.equals(userName, that.userName) && Objects.equals(orderNo, that.orderNo) && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(consignee, that.consignee) && Objects.equals(deliverAddress, that.deliverAddress) && Objects.equals(consigneeCellPhoneNumber, that.consigneeCellPhoneNumber) && Objects.equals(freight, that.freight) && Objects.equals(payType, that.payType) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(discountAmount, that.discountAmount) && Objects.equals(couponAmount, that.couponAmount) && Objects.equals(payableAmount, that.payableAmount) && Objects.equals(invoiceTitle, that.invoiceTitle) && Objects.equals(taxpayerId, that.taxpayerId) && Objects.equals(orderComment, that.orderComment) && Objects.equals(gmtCreated, that.gmtCreated) && Objects.equals(gmtModified, that.gmtModified) && Objects.equals(publishedComment, that.publishedComment) && Objects.equals(confirmReceiptTime, that.confirmReceiptTime) && Objects.equals(orderItems, that.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAccountId, userName, orderNo, orderStatus, consignee, deliverAddress, consigneeCellPhoneNumber, freight, payType, totalAmount, discountAmount, couponAmount, payableAmount, invoiceTitle, taxpayerId, orderComment, gmtCreated, gmtModified, publishedComment, confirmReceiptTime, orderItems);
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public Integer getPublishedComment() {
        return publishedComment;
    }

    public void setPublishedComment(Integer publishedComment) {
        this.publishedComment = publishedComment;
    }

    public Date getConfirmReceiptTime() {
        return confirmReceiptTime;
    }

    public void setConfirmReceiptTime(Date confirmReceiptTime) {
        this.confirmReceiptTime = confirmReceiptTime;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
