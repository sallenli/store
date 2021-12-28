package com.store.commodity.service.impl;

import com.store.commodity.dao.PropertyDao;
import com.store.commodity.domain.PropertyDo;
import com.store.commodity.domain.PropertyDto;
import com.store.commodity.domain.PropertyQuery;
import com.store.commodity.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理模块service组件
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
    @Autowired
    PropertyDao propertyDao;

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     * 通配符%放后面，用来走索引
     */
    @Override
    public List<PropertyDto> listPropertiesByPage(PropertyQuery propertyQuery) {
        try {
            List<PropertyDo> propertyDos = propertyDao.listPropertiesByPage(propertyQuery);
            List<PropertyDto> propertyDtos = new ArrayList<>(propertyDos.size());
            for (PropertyDo propertyDo:propertyDos) {
                propertyDtos.add(propertyDo.clone(PropertyDto.class));
            }
            return propertyDtos;
        } catch (Exception e) {
            logger.error("PropertyServiceImpl.listPropertiesByPage",e.getMessage());
            return  new ArrayList<PropertyDto>();
        }
    }
    /**
     * 属性存储
     * @param propertyDto
     * @return
     */
    @Override
    public Boolean saveProperty(PropertyDto propertyDto) {
        try {
            PropertyDo propertyDo = propertyDto.clone(PropertyDo.class);
            return  propertyDao.saveProperty(propertyDo);

        } catch (Exception e) {
            logger.error("PropertyServiceImpl.saveProperty",e.getMessage());
            return false;
        }
    }
    /**
     * 根据id查询商品属性do对象
     * @param id 商品属性id
     * @return 商品属性
     */
    @Override
    public PropertyDto getPropertyById(Long id) {
        try {
            PropertyDo propertyDo = propertyDao.getPropertyById(id);
            return propertyDo.clone(PropertyDto.class);
        } catch (Exception e) {
            logger.error("PropertyServiceImpl.getPropertyById",e.getMessage());
            return new PropertyDto();
        }
    }
    /**
     * 更新商品属性
     * @param propertyDto 商品属性do对象
     */

    @Override
    public Boolean updateProperty(PropertyDto propertyDto) {
        try {
            return propertyDao.updateProperty(propertyDto.clone(PropertyDo.class));

        } catch (Exception e) {
            logger.error("PropertyServiceImpl.updateProperty",e.getMessage());
            return false;
        }
    }
}
