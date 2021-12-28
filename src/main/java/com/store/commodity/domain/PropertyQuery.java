package com.store.commodity.domain;



import java.util.Objects;

/**
 * 商品属性的查询条件
 */

public class PropertyQuery  {

    //分页的起始位置
    private Integer offset;
    //每页的数据
    private Integer size;
    //属性名称
    private String propertyName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyQuery that = (PropertyQuery) o;
        return Objects.equals(offset, that.offset) && Objects.equals(size, that.size) && Objects.equals(propertyName, that.propertyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, size, propertyName);
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}

