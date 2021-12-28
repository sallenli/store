package com.store.cart.dao.impl;

import com.store.cart.dao.ShoppingCartItemDao;
import com.store.cart.domain.ShoppingCartItemDo;
import com.store.cart.mapper.ShoppingCartItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车条目dao
 */
@Repository
public class ShoppingCartItemDaoImpl implements ShoppingCartItemDao {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDaoImpl.class);

    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;

    @Override
    public Long saveShoppingCartItem(ShoppingCartItemDo shoppingCartItemDo) {
        try {
            shoppingCartItemMapper.saveShoppingCartItem(shoppingCartItemDo);
            return shoppingCartItemDo.getId();
        } catch (Exception e) {
            logger.error("ShoppingCartItemDaoImpl.saveShoppingCartItem",e.getMessage());
            return null;
        }
    }

    @Override
    public ShoppingCartItemDo getShoppingCartItemByGoodsSkuId(Long shoppingCartId, Long goodsSkuId) {
        try {
            return shoppingCartItemMapper.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);
        } catch (Exception e) {
            logger.error("ShoppingCartItemDaoImpl.getShoppingCartItemByGoodsSkuId",e.getMessage());
            return null;
        }

    }

    @Override
    public Boolean updateShoppingCartItem(ShoppingCartItemDo shoppingCartItemDo) {
        try {
            shoppingCartItemMapper.updateShoppingCartItem(shoppingCartItemDo);
            return true;
        } catch (Exception e) {
            logger.error("ShoppingCartItemDaoImpl.updateShoppingCartItem",e.getMessage());
            return false;
        }

    }

    @Override
    public List<ShoppingCartItemDo> listShoppingCartItemByCartId(Long shoppingCartId) {
        try {
            return shoppingCartItemMapper.getShoppingCartItemByCartId(shoppingCartId);
        } catch (Exception e) {
            logger.error("ShoppingCartItemDaoImpl.getShoppingCartItemByCartId",e.getMessage());
            return null;
        }
    }
}
