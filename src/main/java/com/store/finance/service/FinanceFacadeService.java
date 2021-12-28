package com.store.finance.service;

import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;
import com.store.wms.domain.SalesDeliveryOrderDto;

/**
 * 财务中心对外暴露接口
 */
public interface FinanceFacadeService {
    /**
     * 创建采购结算单
     * @param purchaseInputOrderDto 采购入库单dto
     * @return
     */
    Boolean createPurchaseSettlementOrder(PurchaseInputOrderDto purchaseInputOrderDto);

    /**
     * 给物流公司打款
     * @param salesDeliveryOrderDto 销售出库单
     * @return
     */
    Boolean payForLogisticsCompany(SalesDeliveryOrderDto salesDeliveryOrderDto);

    /**
     * 执行退货打款
     * @param returnGoodsInputOrderDto 退货入库单dto
     * @return
     */
    Boolean executeReturnGoodsRefund(ReturnGoodsInputOrderDto returnGoodsInputOrderDto);
}
