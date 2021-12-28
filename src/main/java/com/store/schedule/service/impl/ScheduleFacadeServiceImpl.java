package com.store.schedule.service.impl;

import com.store.customer.domain.ReturnGoodsWorksheetDto;
import com.store.order.domain.OrderInfoDto;
import com.store.purchase.domain.PurchaseOrderDto;
import com.store.schedule.service.ScheduleFacadeService;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;
import org.springframework.stereotype.Service;

/**
 * 调度中心对外接口service
 */
@Service
public class ScheduleFacadeServiceImpl implements ScheduleFacadeService {
    @Override
    public Boolean informPurchaseInputFinished(PurchaseInputOrderDto purchaseInputOrderDto) {
        return null;
    }

    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDto orderDto) {
        return null;
    }

    @Override
    public Boolean informPayOrderEvent(OrderInfoDto orderDto) {
        return null;
    }

    @Override
    public Boolean informCancelOrderEvent(OrderInfoDto orderDto) {
        return null;
    }

    @Override
    public Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDto returnGoodsInputOrderDto) {
        return null;
    }

    @Override
    public Boolean schedulePurchaseInput(PurchaseOrderDto purchaseOrderDto) {
        return null;
    }

    @Override
    public Boolean scheduleSaleDelivery(OrderInfoDto orderDto) {
        return null;
    }

    @Override
    public Boolean scheduleReturnGoodsInput(OrderInfoDto orderDto, ReturnGoodsWorksheetDto returnGoodsWorksheetDto) {
        return null;
    }
}
