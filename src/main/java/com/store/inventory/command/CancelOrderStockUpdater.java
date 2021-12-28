package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import com.store.order.domain.OrderItemDto;

import java.util.List;
import java.util.Map;

/**
 * 取消订单库存更新组件
 */

public class CancelOrderStockUpdater extends AbstractGoodsStockUpdateCommand {
    /**
     * 订单条条目dto集合
     */
    private Map<Long, OrderItemDto> orderItemDtoMap;

    /**
     *
     * @param goodsStockDos  商品库存do对象集合
     * @param goodsStockDao  商品库存管理模块dao组件
     * @param dateProvider
     */
    public CancelOrderStockUpdater(List<GoodsStockDo> goodsStockDos, GoodsStockDao goodsStockDao, DateProvider dateProvider, Map<Long, OrderItemDto> orderItemDtoMap) {
        super(goodsStockDos, goodsStockDao, dateProvider);
        orderItemDtoMap = orderItemDtoMap;
    }

    @Override
    protected void updateSaleStockQuantity() throws Exception {
        for(GoodsStockDo goodsStockDo : goodsStockDos){
            OrderItemDto orderItemDto = orderItemDtoMap.get(goodsStockDo.getGoodsSkuId());
            goodsStockDo.setSaleStockQuantity(goodsStockDo.getSaleStockQuantity() + orderItemDto.getPurchaseQuantity());

        }
    }

    @Override
    protected void updateLockedStockQuantity() throws Exception {
        for(GoodsStockDo goodsStockDo : goodsStockDos) {
            OrderItemDto orderItemDto = orderItemDtoMap.get(goodsStockDo.getGoodsSkuId());
            goodsStockDo.setLockedStockQuantity(goodsStockDo.getSaleStockQuantity() - orderItemDto.getPurchaseQuantity());

        }

    }

    @Override
    protected void updateSaledStockQuantity() throws Exception {

    }
}
