package com.store.wms.domain;


import java.util.Date;
import java.util.Objects;

/**
 * 采购入库单条目dto类
 */

public class PurchaseInputOrderItemDto {
    /**
     * 主键
     */
    private Long id;
    /**
     * 采购入库单id
     */
    private Long purchaseInputOrderId;
    /**
     * 商品sku id
     */
    private Long goodsSkuId;
    /**
     * 采购数量
     */
    private Long purchaseCount;
    /**
     * 采购价格
     */
    private Long purchasePrice;
    /**
     * 合格商品的数量
     */
    private Long qualifiedCount;
    /**
     * 实际到货的数量
     */
    private Long arrivalCount;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date getGmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseInputOrderItemDto that = (PurchaseInputOrderItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(purchaseInputOrderId, that.purchaseInputOrderId) && Objects.equals(goodsSkuId, that.goodsSkuId) && Objects.equals(purchaseCount, that.purchaseCount) && Objects.equals(purchasePrice, that.purchasePrice) && Objects.equals(qualifiedCount, that.qualifiedCount) && Objects.equals(arrivalCount, that.arrivalCount) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(getGmtModified, that.getGmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchaseInputOrderId, goodsSkuId, purchaseCount, purchasePrice, qualifiedCount, arrivalCount, gmtCreate, getGmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseInputOrderId() {
        return purchaseInputOrderId;
    }

    public void setPurchaseInputOrderId(Long purchaseInputOrderId) {
        this.purchaseInputOrderId = purchaseInputOrderId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Long getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Long purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Date getGetGmtModified() {
        return getGmtModified;
    }

    public void setGetGmtModified(Date getGmtModified) {
        this.getGmtModified = getGmtModified;
    }
}
