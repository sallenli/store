package com.store.cart.smoke;

import com.alibaba.fastjson.JSONObject;
import com.store.cart.controller.ShoppingCartController;
import com.store.cart.domain.ShoppingCartVo;
import com.store.cart.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * 冒烟测试
 */
@RunWith(SpringRunner.class)
//模拟mvc环境下,会加载所有被Spring容器管理的bean
@AutoConfigureMockMvc
@SpringBootTest
public class ShoppingCartSmokeTest {

    @Autowired
    private MockMvc mockMvc;

   @Test
    public  void  test_addShoppingCartItem_smoke() throws Exception{
        Long userAccountId = 1L;
        Long goodsSkuId = 1L;
        ShoppingCartVo shoppingCartVo = new ShoppingCartVo();
        shoppingCartVo.setUserAccountId(userAccountId);
        shoppingCartVo.setGoodSkuId(goodsSkuId);
        //mock service层行为

        //mvc 模拟发送post请求，以及返回结果
        mockMvc.perform(post("/cart/item/add").
                contentType("application/json")
                .content(JSONObject.toJSONString(shoppingCartVo))).andExpect(content().string("true"));
    }
}
