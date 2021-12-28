package com.store.inventory.Mapper;


import com.store.inventory.domain.GoodsStockDo;
import org.apache.ibatis.annotations.*;

/**
 * 商品sku库存管理模块 mapper组件
 */
@Mapper
public interface GoodsStockMapper {
    /**
     * 根据商品sku id 查询商品库存
     * @param goodsSkuId 商品sku id
     * @return 商品库存
     */
    @Select("select " +
            "id," +
            "goods_sku_id," +
            "sale_stock_quantity," +
            "locked_stock_quantity," +
            "saled_stock_quantity," +
            "stock_status," +
            "gmt_create," +
            "gmt_modified " +
            "from inventory_goods_stock " +
            "where goods_sku_id = #{goodsSkuId}")
    @Results({
            @Result(column =  "id", property = "id" ,id =true),
            @Result(column =  "goods_sku_id", property = "goodsSkuId" ),
            @Result(column =  "sale_stock_quantity", property = "saleStockQuantity" ),
            @Result(column =  "locked_stock_quantity", property = "lockedStockQuantity" ),
            @Result(column =  "saled_stock_quantity", property = "saledStockQuantity" ),
            @Result(column =  "stock_status", property = "stockStatus" ),
            @Result(column =  "gmt_create", property = "gmtCreate" ),
            @Result(column =  "gmt_modified", property = "gmtModified" )
    })
    GoodsStockDo getGoodsStockBySkuId(@Param("goodsSkuId")Long goodsSkuId);

    /**
     * 新增商品库存
     * @param goodsStockDo  商品库存do对象
     */
    @Insert("insert into inventory_goods_stock " +
            "(goods_sku_id," +
            "sale_stock_quantity," +
            "locked_stock_quantity," +
            "saled_stock_quantity," +
            "stock_status," +
            "gmt_create," +
            "gmt_modified)"+
            "values(" +
            "#{goodsSkuId}," +
            "#{saleStockQuantity}," +
            "#{lockedStockQuantity}," +
            "#{saledStockQuantity}," +
            "#{stockStatus}," +
            "#{gmtCreate}," +
            "#{gmtModified})"
    )
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    Long  saveGoodsStock(GoodsStockDo goodsStockDo);

    /**
     * 更新商品库存
     * @param goodsStockDo
     */
    @Update("update " +
            "inventory_goods_stock " +
            "set" +
            "sale_stock_quantity = #{saleStockQuantity}," +
            "locked_stock_quantity = #{lockedStockQuantity}，" +
            "saled_stock_quantity = #{saleStockQuantity}," +
            "stock_status = #{stockStatus}," +
            "gmt_modified = #{gmtModified}" +
            "where id = #{id}")
    void  updateGoodsStock(GoodsStockDo goodsStockDo);
}
