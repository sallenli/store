package com.store.commodity.mapper;

import com.store.commodity.domain.PropertyDo;
import com.store.commodity.domain.PropertyQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 商品属性管理模块mapper
 */
@Mapper
public interface PropertyMapper {

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     * 通配符%放后面，用来走索引
     */
    @Select("<script>"+
            "select" +
            "id," +
            "property_name，" +
            "property_desc，" +
            "input_type，" +
            "input_values，" +
            "gmt_create，" +
            "gmt_modified"+
            "from commodity_property a ,(select" +
                    " id from commodity_property" +
            "<if test = \"property_name != '' and property_name != null\">"+
            "where property_name like '#{propertyName}%'"+
            "</if>"+
            "limit #{offset},#{size}) b" +
                    "where a.id = b.id"+
            "</script>"

    )
    //@SelectProvider(type = PropertySelectProvider.class, method = "getSelectSQL") provider 去重构动态sql
    @Results({@Result(column = "id",property = "id",id = true), //用来判断id为是否为主键，其中id=true说明id为主键。
             @Result(column = "property_name",property = "propertyName"),
            @Result(column = "property_desc",property = "propertyDesc"),
            @Result(column = "input_type",property = "inputType"),
            @Result(column = "input_values",property = "inputValues"),
            @Result(column = "gmt_create",property = "gmtCreate"),
            @Result(column = "gmt_modified",property = "gmtModified")
    })
    List<PropertyDo> listPropertiesByPage(PropertyQuery propertyQuery);

    /**
     * 新增属性
     * @param propertyDo 商品属性do对象
     */
    @Insert("insert into " +
            "commodity_property" +
            "(property_name," +
            "property_desc," +
            "input_type," +
            "input_values," +
            "gmt_create," +
            "gmt_modified" +
            ")"+
            "values(" +
            "#{propertyName}," +
            "#{propertyDesc}," +
            "#{inputType}," +
            "#{inputValues}," +
            "#{gmtCreate}," +
            "#{gmtModified})"
    )
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void saveProperty(PropertyDo propertyDo);

    /**
     * 根据id查询商品属性do对象
     * @param id 商品属性id
     * @return 商品属性
     */
    @Select(
            "select" +
                    "id," +
                    "property_name，" +
                    "property_desc，" +
                    "input_type，" +
                    "input_values，" +
                    "gmt_create，" +
                    "gmt_modified"+
                    "from commodity_property"+
                    "where id = #{id}"
    )
    @Results({@Result(column = "id",property = "id",id = true), //用来判断id为是否为主键，其中id=true说明id为主键。
            @Result(column = "property_name",property = "propertyName"),
            @Result(column = "property_desc",property = "propertyDesc"),
            @Result(column = "input_type",property = "inputType"),
            @Result(column = "input_values",property = "inputValues"),
            @Result(column = "gmt_create",property = "gmtCreate"),
            @Result(column = "gmt_modified",property = "gmtModified")
    })
    PropertyDo getPropertyById(@Param("id") Long id);

    /**
     * 商品属性do对象
     * @param propertyDo 商品属性do对象
     */
    @Update("update commodity_property" +
            "set " +
            "property_name = #{propertyName}" +
            "property_desc = #{propertyDesc}" +
            "input_values = #{inputValues}" +
            "gmt_modified = #{gmtModified}" +
            "where id =#{id}")
    void updateProperty(PropertyDo propertyDo);
}
