package com.store.wms.domain;



import java.util.Date;
import java.util.Objects;

/**
 * 退货入库单条目dto
 */

public class ReturnGoodsInputOrderItemDto {
        /*
        主键id
         */
    private Long id;
    /*
            退货入库单id
     */
    private Long returnGoodsInputOrderId;
    /*
        商品skuid
     */
    private Long goodsSkuId;
    /*
商品sku编号
     */
    private Long goodsSkuCode;
    /*
    商品名称
     */
    private String goodsName;
    /*
销售属性(机身颜色)
     */
    private String saleProperties;
    /*
商品毛重
     */
    private Double goodsGrossWeight;
    /*
购买数量
     */
    private Long purchaseQuantity;
    /*
商品购买价格
     */
    private Double purchasePrice;
    /*
促销活动id
     */
    private Long promotionActivityId;
    /*
商品长度
     */
    private Double goodsLength;
    /*
商品宽度
     */
    private Double goodsWidth;
    /*
商品高度
     */
    private Double goodHeight;
    /*
退货商品到货后质检出的合格商品数量
     */
    private Long qualifiedCount;
    /*
商品到货数量
     */
    private Long arrivalCount;
    /*
创建时间
     */
    private Date gmtCreate;
    /*
修改时间
     */
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnGoodsInputOrderItemDto that = (ReturnGoodsInputOrderItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(returnGoodsInputOrderId, that.returnGoodsInputOrderId) && Objects.equals(goodsSkuId, that.goodsSkuId) && Objects.equals(goodsSkuCode, that.goodsSkuCode) && Objects.equals(goodsName, that.goodsName) && Objects.equals(saleProperties, that.saleProperties) && Objects.equals(goodsGrossWeight, that.goodsGrossWeight) && Objects.equals(purchaseQuantity, that.purchaseQuantity) && Objects.equals(purchasePrice, that.purchasePrice) && Objects.equals(promotionActivityId, that.promotionActivityId) && Objects.equals(goodsLength, that.goodsLength) && Objects.equals(goodsWidth, that.goodsWidth) && Objects.equals(goodHeight, that.goodHeight) && Objects.equals(qualifiedCount, that.qualifiedCount) && Objects.equals(arrivalCount, that.arrivalCount) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, returnGoodsInputOrderId, goodsSkuId, goodsSkuCode, goodsName, saleProperties, goodsGrossWeight, purchaseQuantity, purchasePrice, promotionActivityId, goodsLength, goodsWidth, goodHeight, qualifiedCount, arrivalCount, gmtCreate, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReturnGoodsInputOrderId() {
        return returnGoodsInputOrderId;
    }

    public void setReturnGoodsInputOrderId(Long returnGoodsInputOrderId) {
        this.returnGoodsInputOrderId = returnGoodsInputOrderId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Long getGoodsSkuCode() {
        return goodsSkuCode;
    }

    public void setGoodsSkuCode(Long goodsSkuCode) {
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

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Double getGoodHeight() {
        return goodHeight;
    }

    public void setGoodHeight(Double goodHeight) {
        this.goodHeight = goodHeight;
    }

    public Long getQualifiedCount() {
        return qualifiedCount;
    }

    public void setQualifiedCount(Long qualifiedCount) {
        this.qualifiedCount = qualifiedCount;
    }

    public Long getArrivalCount() {
        return arrivalCount;
    }

    public void setArrivalCount(Long arrivalCount) {
        this.arrivalCount = arrivalCount;
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
