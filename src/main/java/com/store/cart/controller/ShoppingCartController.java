package com.store.cart.controller;

import com.store.cart.domain.ShoppingCartDto;
import com.store.cart.domain.ShoppingCartItemDto;
import com.store.cart.domain.ShoppingCartItemVo;
import com.store.cart.domain.ShoppingCartVo;
import com.store.cart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车管理模块controller
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    @Autowired
    private ShoppingCartService shoppingCartService;
    /**
     * 添加购物车商品条目
     * @param shoppingCartVo userAccountId 用户账号id
     * @param shoppingCartVo goodsSkuId 商品skuid
     * @return 处理结果
     */
    @PostMapping("/item/add")
//@RequestBody 对服务器发送json请求
   public Boolean addShoppingCartItem(@RequestBody ShoppingCartVo shoppingCartVo){
       try {
          return shoppingCartService.addShoppingCartItem(shoppingCartVo.getUserAccountId(),shoppingCartVo.getGoodSkuId());

       } catch (Exception e) {
           logger.error("ShoppingCartController.addShoppingCartItem",e.getMessage());
           return  false;
       }
   }

    /**
     * 查看购物车
     * @param userAccountId 用户账号id
     * @return
     */
    @GetMapping("/view/{userAccountId}")
    public ShoppingCartVo getShoppingCartVo(@PathVariable("userAccountId")Long userAccountId){
        try {

            ShoppingCartDto shoppingCartDto = shoppingCartService.getShoppingCartDtoByUserAccountId(userAccountId);
            ShoppingCartVo shoppingCartVo =  shoppingCartDto.clone(ShoppingCartVo.class);
            List<ShoppingCartItemVo> shoppingCartItemVos = new ArrayList<ShoppingCartItemVo>();
            shoppingCartVo.setShoppingCartItemVoList(shoppingCartItemVos);
            for(ShoppingCartItemDto shoppingCartItemDto: shoppingCartDto.getShoppingCartItemDtoList()){
                shoppingCartItemVos.add(shoppingCartItemDto.clone(ShoppingCartItemVo.class));
            }
            return shoppingCartVo;
        } catch (Exception e) {
            logger.error("ShoppingCartController.getShoppingCartVo",e.getMessage());
            return new ShoppingCartVo();
        }
    }


}
