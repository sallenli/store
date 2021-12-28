package com.store.cart.service;

import com.store.cart.domain.ShoppingCartDo;
import com.store.cart.domain.ShoppingCartDto;

/**
 * 购物车service接口
 */
public interface ShoppingCartService {

    /**
     * 添加购物车商品条目
     * @param userAccountId 用户账号id
     * @param goodsSkuId 商品skuid
     * @return 处理结果
     */
    Boolean addShoppingCartItem(Long userAccountId,Long goodsSkuId);

    /**
     * 查看用户购物车数据
     * @param userAccountId 用户账号id
     * @return
     */
    ShoppingCartDto getShoppingCartDtoByUserAccountId(Long userAccountId);
}
