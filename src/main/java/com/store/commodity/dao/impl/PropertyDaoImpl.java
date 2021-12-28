package com.store.commodity.dao.impl;

import com.store.commodity.dao.PropertyDao;
import com.store.commodity.domain.PropertyDo;
import com.store.commodity.domain.PropertyQuery;
import com.store.commodity.mapper.PropertyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyDaoImpl implements PropertyDao {

    private static  final Logger logger = LoggerFactory.getLogger(PropertyDaoImpl.class);
    /**
     * 属性mapper
     */
    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public List<PropertyDo> listPropertiesByPage(PropertyQuery propertyQuery) {
        try {
            return propertyMapper.listPropertiesByPage(propertyQuery);
        }
        catch (Exception e){
            logger.error("PropertyDaoImpl.listPropertiesByPage",e.getMessage());
            return  new ArrayList<PropertyDo>();
        }

    }

    @Override
    public Boolean saveProperty(PropertyDo propertyDo) {
        try {
            propertyMapper.saveProperty(propertyDo);
            return true;
        } catch (Exception e) {
            logger.error("PropertyDaoImpl.saveProperty",e.getMessage());
            return false;
        }

    }

    @Override
    public PropertyDo getPropertyById(Long id) {
        try {
           return propertyMapper.getPropertyById(id);
        } catch (Exception e) {
            logger.error("PropertyDaoImpl.getPropertyById",e.getMessage());
            return new PropertyDo();
        }

    }
    /**
     * 更新商品属性
     * @param propertyDo 商品属性do对象
     */

    @Override
    public Boolean updateProperty(PropertyDo propertyDo) {
        try {
            propertyMapper.updateProperty(propertyDo);
            return true;
        } catch (Exception e) {
            logger.error("PropertyDaoImpl.updateProperty",e.getMessage());
            return false;
        }

    }
}
