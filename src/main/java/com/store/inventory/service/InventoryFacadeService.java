package com.store.inventory.service;

import com.store.order.domain.OrderInfoDto;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;

/**
 * 库存中心对外暴露接口
 */
public interface InventoryFacadeService {
    /**
     * 通知库存中心，采购入库完成
     * @param purchaseInputOrderDto 采购入库单dto
     * @return
     */
    Boolean informPurchaseInputFinished(PurchaseInputOrderDto purchaseInputOrderDto);

    /**
     * 通知库存中心,订单提交完成
     * @param orderDto 订单dto
     * @return
     */
    Boolean informSubmitOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知库存中心，支付订单事件完成
     * @param orderDto
     * @return
     */
    Boolean informPayOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知库存中心，取消订单事件
     * @param orderDto 订单dto
     * @return
     */
    Boolean informCancelOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知库存中心，退货入库事件发生
     * @param returnGoodsInputOrderDto 退货入库单dto
     * @return
     */
    Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDto returnGoodsInputOrderDto);

    /**
     * 查询商品sku的库存
     * @param goodsSkuId 商品skuid
     * @return
     */
    Long getSaleStockQuantity(Long goodsSkuId);
}
