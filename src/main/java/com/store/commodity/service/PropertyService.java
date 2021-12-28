package com.store.commodity.service;

import com.store.commodity.domain.PropertyDo;
import com.store.commodity.domain.PropertyDto;
import com.store.commodity.domain.PropertyQuery;

import java.util.List;

/**
 * 商品属性模块service接口
 */
public interface PropertyService {
    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     * 通配符%放后面，用来走索引
     */

    List<PropertyDto> listPropertiesByPage(PropertyQuery propertyQuery);

    /**
     * 属性存储
     * @param propertyDto
     * @return
     */
    Boolean saveProperty(PropertyDto propertyDto);

    /**
     * 根据id查询商品属性do对象
     * @param id 商品属性id
     * @return 商品属性
     */

    PropertyDto getPropertyById(Long id);

    /**
     * 更新商品属性
     * @param propertyDto 商品属性do对象
     */

    Boolean updateProperty(PropertyDto propertyDto);
}
