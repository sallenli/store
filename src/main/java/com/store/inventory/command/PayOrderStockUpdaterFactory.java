package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import com.store.order.domain.OrderInfoDto;
import com.store.order.domain.OrderItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付订单库存更新组件工厂
 */
@Component
    public class PayOrderStockUpdaterFactory <T> extends  AbstractGoodsStockUpdateCommandFactory<T>{

    private static final Logger logger = LoggerFactory.getLogger(PayOrderStockUpdaterFactory.class);
    /**
     * @param goodsStockDao 商品库存管理模块的dao组件
     * @param dateProvider
     */
    public PayOrderStockUpdaterFactory(GoodsStockDao goodsStockDao, DateProvider dateProvider) {
        super(goodsStockDao, dateProvider);
    }

    /**
     * 获取要更新库存的商品sku id集合
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    protected List<Long> getGoodsSkuIds(T obj) throws Exception {
        try {
            OrderInfoDto orderInfoDto = (OrderInfoDto)obj;
            List<Long> goodsSkuIds = new ArrayList<Long>();

            List<OrderItemDto> orderItemDtos = orderInfoDto.getOrderItems();
            for(OrderItemDto orderItemDto :orderItemDtos){
                goodsSkuIds.add(orderItemDto.getGoodsSkuId());
            }
            return goodsSkuIds;
        } catch (Exception e) {
            logger.error("PayOrderStockUpdaterFactory.getGoodsSkuIds",e.getMessage());
            return null;
        }
    }

    /**
     * 创建商品库存更新组件
     * @param goodsStockDos 商品库存do对象
     * @param obj  订单dto对象
     * @return
     * @throws Exception
     */
    @Override
    protected GoodsStockUpdateCommand create(List<GoodsStockDo> goodsStockDos, T obj) throws Exception {
        try {
            OrderInfoDto orderInfoDto = (OrderInfoDto)obj;
            Map<Long,OrderItemDto> orderItemDtoMap = new HashMap<Long,OrderItemDto>();
            for(OrderItemDto orderItemDto: orderInfoDto.getOrderItems()){
                orderItemDtoMap.put(orderItemDto.getGoodsSkuId(),orderItemDto);
            }
            return new PayOrderStockUpdater(goodsStockDos,goodsStockDao,dateProvider,orderItemDtoMap);
        } catch (Exception e) {
            logger.error("PayOrderStockUpdaterFactory.create",e.getMessage());
            return null;
        }
    }
}
