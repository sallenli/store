package com.store.commodity.controller;

import com.store.commodity.domain.PropertyDo;
import com.store.commodity.domain.PropertyDto;
import com.store.commodity.domain.PropertyQuery;
import com.store.commodity.domain.PropertyVo;
import com.store.commodity.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性管理controller组件
 */
@RestController
@RequestMapping("/commodity/property")
public class PropertyController {

    private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    PropertyService propertyService;
    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     * 通配符%放后面，用来走索引
     */
    @GetMapping("/")
   public List<PropertyVo> listPropertiesByPage(PropertyQuery propertyQuery){
        try {
            List<PropertyDto> propertyDtos = propertyService.listPropertiesByPage(propertyQuery);
            ArrayList<PropertyVo> propertyVos = new ArrayList<>(propertyDtos.size());
            for (PropertyDto propertyDto:propertyDtos) {
                propertyVos.add(propertyDto.clone(PropertyVo.class));
            }
            return propertyVos;
        } catch (Exception e) {
            logger.error("PropertyController.listPropertiesByPage",e.getMessage());
            return new ArrayList<PropertyVo>();
        }
    }

    /**
     * 属性存储
     * @param propertyVo
     * @return
     */
    @PostMapping("/")
    public Boolean saveProperty(@RequestBody PropertyVo propertyVo){
        try {
          return  propertyService.saveProperty(propertyVo.clone(PropertyDto.class));
        } catch (Exception e) {
            logger.error("PropertyController.saveProperty",e.getMessage());
            return false;
        }
    }

    /**
     * 根据id查询商品属性do对象
     * @param id 商品属性id
     * @return 商品属性
     */
    @GetMapping("/{id}")
    public PropertyVo getPropertyById(@PathVariable("id") Long id){
        try {
            return propertyService.getPropertyById(id).clone(PropertyVo.class);
        } catch (Exception e) {
            logger.error("PropertyController.getPropertyById",e.getMessage());
            return  new PropertyVo();
        }
    }

    /**
     * 更新商品属性
     * @param propertyVo 商品属性do对象
     */
    @PutMapping("/{id}")
    Boolean updateProperty(@RequestBody PropertyVo propertyVo){
        try {
           return propertyService.updateProperty(propertyVo.clone(PropertyDto.class));
        } catch (Exception e) {
            logger.error("PropertyController.updateProperty",e.getMessage());
            return false;
        }
    }
}
