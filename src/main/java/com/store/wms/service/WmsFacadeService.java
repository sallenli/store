package com.store.wms.service;

import com.store.order.domain.OrderInfoDto;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;
import com.store.wms.domain.SalesDeliveryOrderDto;

/**
 * @author  sallen
 * WMS对外暴露接口
 */
public interface WmsFacadeService {

    /**
     * 创建采购入库单
     * @param purchaseInputOrderDto 采购入库单
     * @return 处理结果
     */
    Boolean createPurchaseInputOrder(PurchaseInputOrderDto purchaseInputOrderDto);
    /**
    * 创建销售出库单
     * @param salesDeliveryOrderDto  销售出库单dto
    */
    Boolean createSaleDeliveryOrder(SalesDeliveryOrderDto salesDeliveryOrderDto);

    /**
     * 创建退货入库单
     * @param returnGoodsInputOrderDto
     * @return
     */
    Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDto returnGoodsInputOrderDto);

    /**
     * 通知wms提交订单
     * @param orderDto 订单dto
     * @return
     */
    Boolean informSubmitOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知wms中心,支付订单
     * @param orderDto
     * @return
     */
    Boolean informPayOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知wms中心，取消订单
     * @param orderDto
     * @return
     */
    Boolean informCancelOrderEvent(OrderInfoDto orderDto);
}
