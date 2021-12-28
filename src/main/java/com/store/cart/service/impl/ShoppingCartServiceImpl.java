package com.store.cart.service.impl;

import com.store.cart.dao.ShoppingCartDao;
import com.store.cart.dao.ShoppingCartItemDao;
import com.store.cart.domain.ShoppingCartDo;
import com.store.cart.domain.ShoppingCartDto;
import com.store.cart.domain.ShoppingCartItemDo;
import com.store.cart.domain.ShoppingCartItemDto;
import com.store.cart.service.ShoppingCartService;
import com.store.commodity.domain.GoodsSkuDto;
import com.store.commodity.service.CommodityFacadeService;
import com.store.common.utils.DateProvider;
import com.store.inventory.service.InventoryFacadeService;
import com.store.promotion.domain.PromotionActivityDto;
import com.store.promotion.service.PromotionFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Autowired
    private DateProvider dateProvider;
    @Autowired
    private ShoppingCartItemDao shoppingCartItemDao;
    /**
     * 商品中心对外接口
     */
    @Autowired
    CommodityFacadeService commodityFacadeService;
    //库存中心
    @Autowired
    InventoryFacadeService inventoryFacadeService;
    /**
     * 促销中心对外接口
     */
    @Autowired
    private PromotionFacadeService promotionFacadeService;
    @Override
    public Boolean addShoppingCartItem(Long userAccountId, Long goodsSkuId) {
        try {
            Date currentTime = dateProvider.getCurrentTime();
            //先查询用户购物车
            ShoppingCartDo shoppingCartDo = shoppingCartDao.getShoppingCartByUserAccountId(userAccountId);
            if (shoppingCartDo == null) {
                //如果购物车不存在，新增购物车
                shoppingCartDo = new ShoppingCartDo();
                shoppingCartDo.setUserAccountId(userAccountId);
                shoppingCartDo.setGmtCreate(new Date());
                shoppingCartDo.setGmtModified(new Date());
                shoppingCartDao.saveShoppingCart(shoppingCartDo);

            }
            //查询购物车中对应的商品条目
            else {
                ShoppingCartItemDo shoppingCartItemDo = shoppingCartItemDao.getShoppingCartItemByGoodsSkuId(shoppingCartDo.getId(), goodsSkuId);
                //如果没有这个条目，新增一个商品条目
                if (shoppingCartItemDo == null) {
                    shoppingCartItemDo = new ShoppingCartItemDo();
                    shoppingCartItemDo.setShoppingCartId(shoppingCartDo.getId());
                    shoppingCartItemDo.setGoodsSkuId(goodsSkuId);
                    shoppingCartItemDo.setPurchaseQuantity(1L);
                    shoppingCartItemDo.setGmtCreate(new Date());
                    shoppingCartItemDo.setGmtModified(new Date());

                    shoppingCartItemDao.saveShoppingCartItem(shoppingCartItemDo);

                } else {
                    //存在商品条目，更新购物车
                    shoppingCartItemDo.setPurchaseQuantity(shoppingCartItemDo.getPurchaseQuantity() + 1);
                    shoppingCartItemDo.setGmtModified(currentTime);
                    shoppingCartItemDao.updateShoppingCartItem(shoppingCartItemDo);
                }

            }
            return true;
        } catch (Exception e) {
            logger.error("ShoppingCartServiceImpl.addShoppingCartItem",e.getMessage());
            return false;
        }
    }

    @Override
    public ShoppingCartDto getShoppingCartDtoByUserAccountId(Long userAccountId) {
        try {
            //根据用户账号id查询购物车
            ShoppingCartDo shoppingCartDo = shoppingCartDao.getShoppingCartByUserAccountId(userAccountId);
            if(shoppingCartDo == null){
                return  new ShoppingCartDto();
            }
            ShoppingCartDto shoppingCartDto = shoppingCartDo.clone(ShoppingCartDto.class);

            //查询购物车的条目数据
            List<ShoppingCartItemDo> shoppingCartItemDoList = shoppingCartItemDao.listShoppingCartItemByCartId(shoppingCartDto.getId());
            if(shoppingCartItemDoList == null || shoppingCartItemDoList.size() == 0){
                return  shoppingCartDto;
            }
            List<ShoppingCartItemDto> shoppingCartItemDtoList = new ArrayList<>();
            shoppingCartDto.setShoppingCartItemDtoList(shoppingCartItemDtoList);
            for(ShoppingCartItemDo shoppingCartItemDo : shoppingCartItemDoList){
                ShoppingCartItemDto shoppingCartItemDto = shoppingCartItemDo.clone(ShoppingCartItemDto.class);
                //给每个购物车条目填充商品数据
                GoodsSkuDto goodsSkuDto = commodityFacadeService.getGoodsSkuById(shoppingCartItemDto.getGoodsSkuId());
                shoppingCartItemDto.setGoodsId(goodsSkuDto.getGoodsId());
                shoppingCartItemDto.setGoodsHeight(goodsSkuDto.getGoodsHeight());
                shoppingCartItemDto.setGoodsLength(goodsSkuDto.getGoodsLength());
                shoppingCartItemDto.setGoodsName(goodsSkuDto.getGoodsName());
                shoppingCartItemDto.setGoodsSkuCode(goodsSkuDto.getGoodsSkuCode());
                shoppingCartItemDto.setGoodsWidth(goodsSkuDto.getGoodsWidth());
                shoppingCartItemDto.setGrossWeight(goodsSkuDto.getGrossWeight());
                shoppingCartItemDto.setSalePrice(goodsSkuDto.getSalesPirce());
                shoppingCartItemDto.setSaleProperties(goodsSkuDto.getSaleProperties());

                //给购物车条目填充库存数据
                Long saleStockQuantity = inventoryFacadeService.getSaleStockQuantity(shoppingCartItemDto.getGoodsSkuId());
                shoppingCartItemDto.setSaleStockQuantity(saleStockQuantity);

                //给购物车条目添加促销数据
                List<PromotionActivityDto> promotionActivityDtos = promotionFacadeService.ListPromotionActivitiesByGoodsId(shoppingCartItemDto.getGoodsId());
                shoppingCartItemDto.setPromotionActivityDtoList(promotionActivityDtos);
                //添加购物车条目dto对象到集合
                shoppingCartItemDtoList.add(shoppingCartItemDto);
            }

            return shoppingCartDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
