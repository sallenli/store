package com.store.order.domain;



import java.util.Date;
import java.util.Objects;

/**
 * 订单条目dto
 */

public class OrderItemDto {
    //主键id
    private Long id;
    //订单id
    private Long orderInfoId;
    //商品id
    private Long goodsId;
    //商品sku_id
    private Long goodsSkuId;
    //商品sku_编码
    private String goodsSkuCode;
    //商品名称
    private String goodsName;
    //销售属性（机身颜色)
    private String saleProperties;
    //商品毛重
    private Double goodsGrossWeight;
    //商品购买数量
    private Long purchaseQuantity;
    //商品价格
    private Double purchase_price;
    //促销活动id
    private Long promotionActivityId;
    //商品长度
    private Double goodsLength;
    //商品宽度
    private Double goodsWidth;
    //商品高度
    private Double goodsHeight;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(orderInfoId, that.orderInfoId) && Objects.equals(goodsId, that.goodsId) && Objects.equals(goodsSkuId, that.goodsSkuId) && Objects.equals(goodsSkuCode, that.goodsSkuCode) && Objects.equals(goodsName, that.goodsName) && Objects.equals(saleProperties, that.saleProperties) && Objects.equals(goodsGrossWeight, that.goodsGrossWeight) && Objects.equals(purchaseQuantity, that.purchaseQuantity) && Objects.equals(purchase_price, that.purchase_price) && Objects.equals(promotionActivityId, that.promotionActivityId) && Objects.equals(goodsLength, that.goodsLength) && Objects.equals(goodsWidth, that.goodsWidth) && Objects.equals(goodsHeight, that.goodsHeight) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderInfoId, goodsId, goodsSkuId, goodsSkuCode, goodsName, saleProperties, goodsGrossWeight, purchaseQuantity, purchase_price, promotionActivityId, goodsLength, goodsWidth, goodsHeight, gmtCreate, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
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

    public String getGoodsSkuCode() {
        return goodsSkuCode;
    }

    public void setGoodsSkuCode(String goodsSkuCode) {
        this.goodsSkuCode = goodsSkuCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSaleProperties() {
        return saleProperties;
    }

    public void setSaleProperties(String saleProperties) {
        this.saleProperties = saleProperties;
    }

    public Double getGoodsGrossWeight() {
        return goodsGrossWeight;
    }

    public void setGoodsGrossWeight(Double goodsGrossWeight) {
        this.goodsGrossWeight = goodsGrossWeight;
    }

    public Long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Long getPromotionActivityId() {
        return promotionActivityId;
    }

    public void setPromotionActivityId(Long promotionActivityId) {
        this.promotionActivityId = promotionActivityId;
    }

    public Double getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(Double goodsLength) {
        this.goodsLength = goodsLength;
    }

    public Double getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(Double goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public Double getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(Double goodsHeight) {
        this.goodsHeight = goodsHeight;
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
