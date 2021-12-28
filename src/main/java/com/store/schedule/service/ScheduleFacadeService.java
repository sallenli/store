package com.store.schedule.service;

import com.store.customer.domain.ReturnGoodsWorksheetDto;
import com.store.order.domain.OrderInfoDto;

import com.store.purchase.domain.PurchaseOrderDto;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;

/**
 * 调度中心对外暴露接口
 */
public interface ScheduleFacadeService {
    /**
     * 通知调度中心，采购入库完成
     * @param purchaseInputOrderDto 采购入库单dto
     * @return
     */
    Boolean informPurchaseInputFinished(PurchaseInputOrderDto purchaseInputOrderDto);

    /**
     * 通知调度中心,订单提交完成
     * @param orderDto 订单dto
     * @return
     */
    Boolean informSubmitOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知调度中心，支付订单事件完成
     * @param orderDto
     * @return
     */
    Boolean informPayOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知调度中心，取消订单事件
     * @param orderDto 订单dto
     * @return
     */
    Boolean informCancelOrderEvent(OrderInfoDto orderDto);

    /**
     * 通知调度中心，退货入库事件发生
     * @param returnGoodsInputOrderDto 退货入库单dto
     * @return
     */
    Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDto returnGoodsInputOrderDto);

    /**
     * 调度采购入库
     * @param purchaseOrderDto 采购单dto
     * @return
     */
    Boolean schedulePurchaseInput(PurchaseOrderDto purchaseOrderDto);

    /**
     * 调度销售出库
     * @param orderDto 订单dto
     * @return
     */
    Boolean scheduleSaleDelivery(OrderInfoDto orderDto);

    /**
     * 调度退货入库
     * @param orderDto  订单dto
     * @param returnGoodsWorksheetDto 退货工单dto
     * @return
     */
    Boolean scheduleReturnGoodsInput(OrderInfoDto orderDto, ReturnGoodsWorksheetDto returnGoodsWorksheetDto);

}
