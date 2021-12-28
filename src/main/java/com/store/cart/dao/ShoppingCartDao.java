package com.store.cart.dao;

import com.store.cart.domain.ShoppingCartDo;
import org.apache.ibatis.annotations.*;

/**
 * 购物车管理模块dao接口
 */
public interface ShoppingCartDao {
    /**
     * 根据用户账号id查询购物车
     * @param userAccountId 用户账号id
     * @return 购物车
     */
    ShoppingCartDo getShoppingCartByUserAccountId(Long userAccountId);

    /**
     * 新增购物车
     * @param shoppingCartDo 购物车do对象
     */

    Long saveShoppingCart(ShoppingCartDo shoppingCartDo);
}
