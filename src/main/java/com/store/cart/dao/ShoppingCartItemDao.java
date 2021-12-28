package com.store.cart.dao;

import com.store.cart.domain.ShoppingCartItemDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 购物车条目dao
 */
public interface ShoppingCartItemDao {
    /**
     * 新增购物车条目
     * @param shoppingCartItemDo 购物车条目do
     */

    Long saveShoppingCartItem(ShoppingCartItemDo shoppingCartItemDo);

    /**
     * 根据商品sku id查询购物车中是否存在商品条目
     * @param shoppingCartId 购物车id
     * @param goodsSkuId 商品sku id
     * @return 商品条目
     */

    ShoppingCartItemDo getShoppingCartItemByGoodsSkuId(Long shoppingCartId,
                                                       Long goodsSkuId);

    /**
     * 更新购物车条目
     * @param shoppingCartItemDo 购物车条目do对象
     */

    Boolean updateShoppingCartItem(ShoppingCartItemDo shoppingCartItemDo);

    /**
     * 根据购物车 id查询购物车商品条目
     * @param shoppingCartId 购物车id
     * @param
     * @return 商品条目
     */

    List<ShoppingCartItemDo> listShoppingCartItemByCartId(@Param("shoppingCartId")Long shoppingCartId);
}
