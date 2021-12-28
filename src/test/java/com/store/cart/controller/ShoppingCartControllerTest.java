package com.store.cart.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.cart.domain.ShoppingCartVo;
import com.store.cart.service.ShoppingCartService;
import javafx.geometry.Pos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
//模拟mvc环境下
@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {

    //mvc模拟类
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    public void addShoppingCartItem() throws Exception{
                Long userAccountId = 1L;
                Long goodsSkuId = 1L;
        ShoppingCartVo shoppingCartVo = new ShoppingCartVo();
        shoppingCartVo.setUserAccountId(userAccountId);
        shoppingCartVo.setGoodSkuId(goodsSkuId);
        //mock service层行为
        when(shoppingCartService.addShoppingCartItem(userAccountId,goodsSkuId)).thenReturn(true);
        //mvc 模拟发送post请求，以及返回结果
        mockMvc.perform(post("/cart/item/add").
                contentType("application/json")
                .content(JSONObject.toJSONString(shoppingCartVo))).andExpect(content().string("true"));


    }
}