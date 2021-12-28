package com.store.wms.domain;



import java.util.Date;

import java.util.Objects;

/**
 * 退货入库单商品上架条目dto
 */

public class ReturnGoodsInputOrderPutOnItemDto {
    //主键id
    private Long id;
    //退货入库单条目id
    private Long returnGoodsInputOrderItemId;
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
        ReturnGoodsInputOrderPutOnItemDto that = (ReturnGoodsInputOrderPutOnItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(returnGoodsInputOrderItemId, that.returnGoodsInputOrderItemId) && Objects.equals(goodsAllocationId, that.goodsAllocationId) && Objects.equals(putOnShelvesCount, that.putOnShelvesCount) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, returnGoodsInputOrderItemId, goodsAllocationId, putOnShelvesCount, gmtCreate, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReturnGoodsInputOrderItemId() {
        return returnGoodsInputOrderItemId;
    }

    public void setReturnGoodsInputOrderItemId(Long returnGoodsInputOrderItemId) {
        this.returnGoodsInputOrderItemId = returnGoodsInputOrderItemId;
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
