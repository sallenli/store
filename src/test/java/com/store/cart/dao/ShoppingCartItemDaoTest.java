package com.store.cart.dao;

import com.store.cart.domain.ShoppingCartDo;
import com.store.cart.domain.ShoppingCartItemDo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = true)
public class ShoppingCartItemDaoTest {

    @Autowired
    private ShoppingCartItemDao shoppingCartItemDao;

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    /**
     * 测试新增购物车条目
     * @throws Exception
     */
    @Test
    public void saveShoppingCartItem()  throws Exception{
        Long shoppingCartId = 1L;
        Long goodsSkuId = 1L;
        Long purchaseQuantity = 1L;
        ShoppingCartItemDo shoppingCartItem = createShoppingCartItem(shoppingCartId,goodsSkuId,purchaseQuantity);
        Assert.assertNotNull(shoppingCartItem.getId());
        Assert.assertThat(shoppingCartItem.getId(), greaterThan(0L));
    }

    @Test
    public void getShoppingCartItemByGoodsSkuId()  throws Exception{
        Long shoppingCartId = 1L;
        Long goodsSkuId = 1L;
        Long purchaseQuantity = 1L;
        ShoppingCartItemDo shoppingCartItem = createShoppingCartItem(shoppingCartId,goodsSkuId,purchaseQuantity);
        ShoppingCartItemDo shoppingCartItemDo= shoppingCartItemDao.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);
        assertEquals(shoppingCartItem,shoppingCartItemDo);


    }

    @Test
    public void updateShoppingCartItem() throws Exception{
        Long shoppingCartId = 1L;
        Long goodsSkuId = 1L;
        Long purchaseQuantity = 1L;
        ShoppingCartItemDo shoppingCartItem = createShoppingCartItem(shoppingCartId,goodsSkuId,purchaseQuantity);
        //update
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        Long newPurchaseQuantity = purchaseQuantity  + 1;
        shoppingCartItem.setGmtModified(currentTime);
        shoppingCartItem.setPurchaseQuantity( newPurchaseQuantity);
        shoppingCartItemDao.updateShoppingCartItem(shoppingCartItem);

        //再次从数据库中查出结果
        ShoppingCartItemDo newShoppingCartItemDo = shoppingCartItemDao.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);
        assertEquals(currentTime,newShoppingCartItemDo.getGmtModified());
        assertEquals(newPurchaseQuantity,newShoppingCartItemDo.getPurchaseQuantity());


    }

    /**
     * 创建一个购物车条目
     * @param shoppingCartId 商品skuId
     * @param  goodsSkuId 商品skuId
     * @param  purchaseQuantity 购买数量
     */

    private ShoppingCartItemDo  createShoppingCartItem(Long shoppingCartId,Long goodsSkuId,Long purchaseQuantity) throws Exception{

        ShoppingCartItemDo shoppingCartItemDo = new ShoppingCartItemDo();

        shoppingCartItemDo.setShoppingCartId(shoppingCartId);
        shoppingCartItemDo.setGoodsSkuId(goodsSkuId);
        shoppingCartItemDo.setPurchaseQuantity(purchaseQuantity);
        //mysql 对时间的毫秒值进行四舍五入
        //SimpleDateFormat 线程不安全
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        shoppingCartItemDo.setGmtCreate(currentTime);
        shoppingCartItemDo.setGmtModified(currentTime);
        Long id = shoppingCartItemDao.saveShoppingCartItem(shoppingCartItemDo);
        return shoppingCartItemDo;
    }
}
