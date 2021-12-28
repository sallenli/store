package com.store.wms.domain;



import java.util.Date;
import java.util.Objects;

/**
 * 菜狗入库单的商品上架条目
 */

public class PurchaseInputOrderPutOnItemDtO {
    private Long id;
    //采购入库单条目id
    private Long purchaseInputOrderId;
    //货位id
    private Long goodsAllocationId;
    //上架数量
    private Long putOnShelvesCount;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseInputOrderPutOnItemDtO that = (PurchaseInputOrderPutOnItemDtO) o;
        return Objects.equals(id, that.id) && Objects.equals(purchaseInputOrderId, that.purchaseInputOrderId) && Objects.equals(goodsAllocationId, that.goodsAllocationId) && Objects.equals(putOnShelvesCount, that.putOnShelvesCount) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchaseInputOrderId, goodsAllocationId, putOnShelvesCount, gmtCreate, gmtModified);
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

    public Long getGoodsAllocationId() {
        return goodsAllocationId;
    }

    public void setGoodsAllocationId(Long goodsAllocationId) {
        this.goodsAllocationId = goodsAllocationId;
    }

    public Long getPutOnShelvesCount() {
        return putOnShelvesCount;
    }

    public void setPutOnShelvesCount(Long putOnShelvesCount) {
        this.putOnShelvesCount = putOnShelvesCount;
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
