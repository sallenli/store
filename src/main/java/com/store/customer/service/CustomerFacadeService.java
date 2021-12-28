package com.store.customer.service;

/**
 * 客服中心对外暴露接口
 */

public interface CustomerFacadeService {
    /**
     * 创建退货工单
     * @param orderId 订单id
     * @param orderNo 订单编号
     * @param returnGoodsReason 退货理由
     * @param returnGoodsComment 退货备注
     * @return 处理结果
     */
    Boolean createReturnGoodsWorksheet(Long orderId,
                                       String orderNo,
                                       String returnGoodsReason,
                                       String returnGoodsComment);

    /**
     * 同步物流单号
     * @param orderId 订单id
     * @param returnGoods 退货物流单号
     * @return 处理结果
     */
    Boolean syncReturnGoodsCourierNumber(Long orderId,String returnGoods);

    /**
     * 通知客服中心，完成退货入库事件
     * @param returnGoodsWorksheet
     * @return
     */
    Boolean informReturnGoodsInputFinishedEvent(Long returnGoodsWorksheet);

    /**
     * 通知客服中心，完成退款事件
     * @param returnGoodsWorksheetId 退货工单id
     * @return
     */
    Boolean informRefundFinishedEvent(Long returnGoodsWorksheetId);
}
