package com.store.purchase.service;

/**
 * 采购中心对外暴露接口
 * @author  sallen
 * */

public interface PurchaseFacadeService {

    /**
     * 判断是否有关联商品sku
     * @param goodsSkuId 商品sku id
     * @return
     */
    Boolean existRelatedPurchaseOrder(Long goodsSkuId);

    /**
     * 通知采购中心，创建采购入库单事件发生
     * @param purchaseOrderId
     * @return
     */
    Boolean informCreatePurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，完成采购入库单事件发生
     * @param purchaseOrderId
     * @return
     */
    Boolean informFinishePurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，创建采购结算单事件发生
     * @param purchaseOrderId 采购单ID
     * @return 处理结果
     */
    Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，完成采购结算单
     * @param purchaseOrderId
     * @return
     */
    Boolean informFinishePurchaseSettlementOrderEvent(Long purchaseOrderId);

}
