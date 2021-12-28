package com.store.commodity.domain;

import com.store.common.utils.BeanCopierUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 商品属性do类
 */

public class PropertyVo {
    private  static final Logger logger = LoggerFactory.getLogger(PropertyVo.class);
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

    public <T> T clone (Class<T> clz){
        T target = null;
        try {
            target = clz.newInstance();
            BeanCopierUtils.copyProperties(this,target);
            return target;
        } catch (Exception e) {
            logger.error("PropertyDto.clone",e.getMessage());
            return null;
        }
    }
}
