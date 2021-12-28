package com.store.cart.dao.impl;

import com.store.cart.dao.ShoppingCartDao;
import com.store.cart.domain.ShoppingCartDo;
import com.store.cart.mapper.ShoppingCartMapper;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 购物车dao
 */
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartDaoImpl.class);

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public ShoppingCartDo getShoppingCartByUserAccountId(Long userAccountId) {
        try {
            return shoppingCartMapper.getShoppingCartByUserAccountId(userAccountId);
        } catch (Exception e) {
            logger.error("ShoppingCartDaoImpl.getShoppingCartByUserAccountId",e.getMessage());
            return null;
        }
    }

    @Override
    public Long saveShoppingCart(ShoppingCartDo shoppingCartDo) {
        try {
            shoppingCartMapper.saveShoppingCart(shoppingCartDo);
            return shoppingCartDo.getId();
        } catch (Exception e) {
            logger.error("ShoppingCartDaoImpl.saveShoppingCart",e.getMessage());
            return  null;
        }

    }
}
