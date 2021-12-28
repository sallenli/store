package com.store.order.service;

import com.store.order.domain.OrderInfoDto;

import java.util.List;

/**
 * 订单中心对外暴露接口
 */
public interface OrderFacadeService {
    /**
     * 通知订单中心，商品完成发货
     * @param orderId
     * @return
     */
    Boolean informGoodsDeliveryFinishedEvent(Long orderId);

    /**
     * 通知订单中心，退货工单审核不通过
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId);

    /**
     * 通知订单中心，退货工单审核通过
     * @param orderId 订单id

     * @return
     */
    Boolean informReturnGoodsWorksheetApprovedEvent(Long orderId);

    /**
     * 通知订单中心，确认收到退货商品
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsReceivedEvent(Long orderId);
    /**
     * 通知订单中心，退货入库单审核通过
     * @param orderId
     */
    Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId);

    /**
     * 通知订单中心，财务完成打款
     * @param orderId
     * @return
     */
    Boolean informReturnFinishedEvent(Long orderId);

    /**
     * 通知订单中心，订单发表评论
     * @param orderId
     * @return
     */
    Boolean informPublishCommentEvent(Long orderId);

    /**
     * 从订单中心获取超过收货时间7天，还没有发表评论的订单
     *
     * @return 订单信息dto集合
     */
    List<OrderInfoDto>  listNotPublishedCommentOrders();

    /**
     * 通知订单中心，订单批量发表评论事件
     * @param orderIds 订单id集合
     * @return 处理结果
     */
    Boolean informBatchPublishCommentEvent(List<Long> orderIds);

}
