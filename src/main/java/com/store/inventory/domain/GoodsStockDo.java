package com.store.inventory.domain;



import java.util.Date;
import java.util.Objects;

/**
 * 商品sku库存Do类
 */

public class GoodsStockDo {
    /**
     * id
     */
    private Long id;
    /**
     * 商品sku id
     */
    private Long goodsSkuId;
    /**
     * 销售库存
     */
    private Long saleStockQuantity;
    /**
     * 已销售库存
     */
    private Long lockedStockQuantity;
    /**
     * 库存状态
     */
    private int stockStatus;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsStockDo that = (GoodsStockDo) o;
        return stockStatus == that.stockStatus && Objects.equals(id, that.id) && Objects.equals(goodsSkuId, that.goodsSkuId) && Objects.equals(saleStockQuantity, that.saleStockQuantity) && Objects.equals(lockedStockQuantity, that.lockedStockQuantity) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodsSkuId, saleStockQuantity, lockedStockQuantity, stockStatus, gmtCreate, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Long getSaleStockQuantity() {
        return saleStockQuantity;
    }

    public void setSaleStockQuantity(Long saleStockQuantity) {
        this.saleStockQuantity = saleStockQuantity;
    }

    public Long getLockedStockQuantity() {
        return lockedStockQuantity;
    }

    public void setLockedStockQuantity(Long lockedStockQuantity) {
        this.lockedStockQuantity = lockedStockQuantity;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
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
