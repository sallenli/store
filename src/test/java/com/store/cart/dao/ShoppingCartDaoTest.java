package com.store.cart.dao;



import com.store.cart.domain.ShoppingCartDo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

//在spring boot的环境下运行test
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//数据回滚
@Rollback(true)
public  class ShoppingCartDaoTest {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    /**
     * 根据测试用户账号id 查询购物车
     * @throws Exception
     */
    @Test
    public void getShoppingCartByUserAccountId() throws  Exception{
        //构造一个已有的购物车数据
        Long userAccountId = 1L;
        Date currentTime = new Date();
        ShoppingCartDo shoppingCartDo = new ShoppingCartDo();
        shoppingCartDo.setUserAccountId(userAccountId);
        shoppingCartDo.setGmtCreate(currentTime);
        shoppingCartDo.setGmtModified(currentTime);
        //添加一个购物车
        shoppingCartDao.saveShoppingCart(shoppingCartDo);
        //查询购物车
        ShoppingCartDo actualShoppingCartDo = shoppingCartDao.getShoppingCartByUserAccountId(userAccountId);
        Assert.assertEquals(shoppingCartDo,actualShoppingCartDo);
    }

    /**
     * 新增购物车
     */
    @Test
      public void saveShoppingCart() throws Exception{
        Long userAccountId = 1L;
        ShoppingCartDo shoppingCartDo = new ShoppingCartDo();
        shoppingCartDo.setUserAccountId(userAccountId);
        Date currentTime = new Date();
        shoppingCartDo.setGmtCreate(currentTime);
        shoppingCartDo.setGmtModified(currentTime);
        Long id = shoppingCartDao.saveShoppingCart(shoppingCartDo);
        Assert.assertNotNull(id);
    }
    /**
     * 创建一个购物车
     * @param
     */

    private Long addShoppingCart(Long userAccountId) throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        ShoppingCartDo shoppingCartDo = new ShoppingCartDo();
        shoppingCartDo.setUserAccountId(userAccountId);
        shoppingCartDo.setGmtCreate(currentTime);
        shoppingCartDo.setGmtModified(currentTime);
        Long id = shoppingCartDao.saveShoppingCart(shoppingCartDo);
        return  id;
    }
}