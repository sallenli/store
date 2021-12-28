package com.store.cart.mapper;

import com.store.cart.domain.ShoppingCartItemDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 购物车条目Mapper
 */
@Mapper
public interface ShoppingCartItemMapper {
    /**
     * 新增购物车条目
     * @param shoppingCartItemDo 购物车条目do
     */
    @Insert("insert into " +
            "shopping_cart_item" +
            "(" +
            "shopping_cart_id," +
            "goods_sku_id," +
            "purchase_quantity," +
            "gmt_create," +
            "gmt_modified)" +
            "values(" +
            "#{shoppingCartId}," +
            "#{goodsSkuId}," +
            "#{purchaseQuantity}," +
            "#{gmtCreate}," +
            "#{gmtModified})")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    Long saveShoppingCartItem(ShoppingCartItemDo shoppingCartItemDo);

    /**
     * 根据商品sku id查询购物车中是否存在商品条目
     * @param shoppingCartId 购物车id
     * @param goodsSkuId 商品sku id
     * @return 商品条目
     */
    @Select("select " +
            "id," +
            "shopping_cart_id," +
            "goods_sku_id," +
            "purchase_quantity," +
            "gmt_create," +
            "gmt_modified from shopping_cart_item " +
            "where shopping_cart_id = #{shoppingCartId} and " +
            "goods_sku_id = #{goodsSkuId}")
    @Results({@Result(column = "id", property = "id" ,id = true),
              @Result(column = "shopping_cart_id", property = "shoppingCartId"),
              @Result(column = "goods_sku_id", property = "goodsSkuId"),
              @Result(column = "purchase_quantity", property = "purchaseQuantity"),
              @Result(column = "gmt_create", property = "gmtCreate"),
              @Result(column = "gmt_modified", property = "gmtModified")
    })
    ShoppingCartItemDo getShoppingCartItemByGoodsSkuId(@Param("shoppingCartId")Long shoppingCartId,
                                                       @Param("goodsSkuId")Long goodsSkuId);

    /**
     * 更新购物车条目
     * @param shoppingCartItemDo 购物车条目do对象
     */
    @Update("update Shopping_cart_item " +
            "set " +
            "purchase_quantity = #{purchaseQuantity}," +
            "gmt_modified = #{gmtModified} " +
            "where shopping_cart_id = #{shoppingCartId} and " +
            "goods_sku_id = #{goodsSkuId}")
    void updateShoppingCartItem(ShoppingCartItemDo shoppingCartItemDo);


    /**
     * 根据购物车 id查询购物车商品条目
     * @param shoppingCartId 购物车id
     * @param
     * @return 商品条目
     */
    @Select("select " +
            "id," +
            "shopping_cart_id," +
            "goods_sku_id," +
            "purchase_quantity," +
            "gmt_create," +
            "gmt_modified from shopping_cart_item " +
            "where shopping_cart_id = #{shoppingCartId}  "
            )
    @Results({@Result(column = "id", property = "id" ,id = true),
            @Result(column = "shopping_cart_id", property = "shoppingCartId"),
            @Result(column = "goods_sku_id", property = "goodsSkuId"),
            @Result(column = "purchase_quantity", property = "purchaseQuantity"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified")
    })
    List<ShoppingCartItemDo> getShoppingCartItemByCartId(@Param("shoppingCartId")Long shoppingCartId);
}
