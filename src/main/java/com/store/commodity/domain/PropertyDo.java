package com.store.commodity.domain;

import com.store.common.utils.BeanCopierUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Objects;

/**
 * 商品属性do类
 */

public class PropertyDo {
    private static  final Logger logger = LoggerFactory.getLogger(PropertyDo.class);
    //主键
    private Long id;
    //属性名称
    private  String propertyName;
    //属性描述
    private String propertyDesc;
    //输入类型
    private Integer inputType;
    //可取值范围
    private String inputValues;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyDo that = (PropertyDo) o;
        return Objects.equals(id, that.id) && Objects.equals(propertyName, that.propertyName) && Objects.equals(propertyDesc, that.propertyDesc) && Objects.equals(inputType, that.inputType) && Objects.equals(inputValues, that.inputValues) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyName, propertyDesc, inputType, inputValues, gmtCreate, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputValues() {
        return inputValues;
    }

    public void setInputValues(String inputValues) {
        this.inputValues = inputValues;
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

    public  <T> T clone(Class<T> clz){
        T target = null;
        try {
            target = clz.newInstance();
             BeanCopierUtils.copyProperties(this,target);
             return  target;
        } catch (Exception e) {
            logger.error("PropertyDo.clone",e.getMessage());
            return null;
        }

    }
}
