package com.store.cart.service;

import com.store.cart.dao.ShoppingCartDao;
import com.store.cart.dao.ShoppingCartItemDao;
import com.store.cart.domain.ShoppingCartDo;
import com.store.cart.domain.ShoppingCartItemDo;
import com.store.common.utils.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {

    /**
     * 购物车管理模块service组件
     */
    @Autowired
    private ShoppingCartService shoppingCartService;

    @MockBean
    private DateProvider dateProvider;
    /**
     * 购物车管理模块dao组件 service 依赖dao
     */
    @MockBean
    private ShoppingCartDao shoppingCartDao;
    /**
     * 购物车条目管理模块dao组件
     */
    @MockBean
    private ShoppingCartItemDao shoppingCartItemDao;
    @Test
    public void addShoppingCartItem() throws Exception {
        //准备参数
        Long userAccountId = 1L;
        Long goodsSkuId = 1L;
        Long quantity = 1L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        ShoppingCartDo shoppingCartDo = createShoppingCartDo(userAccountId);
        //mock shoppingCartDo
        when(shoppingCartDao.getShoppingCartByUserAccountId(userAccountId)).thenReturn(shoppingCartDo);
        ShoppingCartItemDo  shoppingCartItemDo = createShoppingCartItem(shoppingCartDo.getId(),goodsSkuId,quantity);
        //mock shoppingCartItemDo
        when(shoppingCartItemDao.getShoppingCartItemByGoodsSkuId(shoppingCartDo.getId(),goodsSkuId)).thenReturn(shoppingCartItemDo);
        //执行方法
        when(dateProvider.getCurrentTime()).thenReturn(currentTime);
        when(shoppingCartItemDao.updateShoppingCartItem(shoppingCartItemDo)).thenReturn(true);

        shoppingCartItemDo.setPurchaseQuantity(shoppingCartItemDo.getPurchaseQuantity()+1L);
        //执行service方法
        Boolean result = shoppingCartService.addShoppingCartItem(userAccountId, goodsSkuId);
        //判断service结果是否为true
        assertTrue(result);
        //验证方法被调用几次
        verify(shoppingCartDao,times(1)).getShoppingCartByUserAccountId(userAccountId);
        verify(shoppingCartItemDao,times(1)).getShoppingCartItemByGoodsSkuId(shoppingCartDo.getId(),goodsSkuId);
        verify(shoppingCartItemDao,times(1)).updateShoppingCartItem(shoppingCartItemDo);
    }

    /**
     * 创建购物车对象
     * @return
     * @throws Exception
     */
    private ShoppingCartDo createShoppingCartDo(Long userAccountId) throws Exception {
        Long id = 1L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        ShoppingCartDo shoppingCartDo = new ShoppingCartDo();
        shoppingCartDo.setId(id);
        shoppingCartDo.setUserAccountId(userAccountId);
        shoppingCartDo.setGmtCreate(currentTime);
        shoppingCartDo.setGmtModified(currentTime);
        return shoppingCartDo;
    }

    /**
     * 创建购物车条目对象
     * @param shoppingCartId
     * @param goodsSkuId
     * @param purchaseQuantity
     * @return
     * @throws Exception
     */
    private ShoppingCartItemDo createShoppingCartItem(Long shoppingCartId, Long goodsSkuId, Long purchaseQuantity) throws Exception{
        Long id = 1L;
        ShoppingCartItemDo shoppingCartItemDo = new ShoppingCartItemDo();

        shoppingCartItemDo.setShoppingCartId(shoppingCartId);
        shoppingCartItemDo.setGoodsSkuId(goodsSkuId);
        shoppingCartItemDo.setPurchaseQuantity(purchaseQuantity);
        //mysql 对时间的毫秒值进行四舍五入
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        shoppingCartItemDo.setGmtCreate(currentTime);
        shoppingCartItemDo.setGmtModified(currentTime);
        shoppingCartItemDo.setId(id);

        return shoppingCartItemDo;
    }
}