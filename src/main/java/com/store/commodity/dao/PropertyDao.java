package com.store.commodity.dao;

import com.store.commodity.domain.PropertyDo;
import com.store.commodity.domain.PropertyQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 商品属性模块dao接口
 */
public interface PropertyDao {

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     * 通配符%放后面，用来走索引
     */

    List<PropertyDo> listPropertiesByPage(PropertyQuery propertyQuery);

    /**
     * 属性存储
     * @param propertyDo
     * @return
     */
    Boolean saveProperty(PropertyDo propertyDo);

    /**
     * 根据id查询商品属性do对象
     * @param id 商品属性id
     * @return 商品属性
     */

    PropertyDo getPropertyById( Long id);

    /**
     * 更新商品属性
     * @param propertyDo 商品属性do对象
     */


    Boolean updateProperty(PropertyDo propertyDo);
}
