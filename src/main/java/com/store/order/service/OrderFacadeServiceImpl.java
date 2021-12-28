package com.store.order.service;

import com.store.order.domain.OrderInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFacadeServiceImpl implements OrderFacadeService{
    @Override
    public Boolean informGoodsDeliveryFinishedEvent(Long orderId) {
        return null;
    }

    @Override
    public Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId) {
        return null;
    }

    @Override
    public Boolean informReturnGoodsWorksheetApprovedEvent(Long orderId) {
        return null;
    }

    @Override
    public Boolean informReturnGoodsReceivedEvent(Long orderId) {
        return null;
    }

    @Override
    public Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId) {
        return null;
    }

    @Override
    public Boolean informReturnFinishedEvent(Long orderId) {
        return null;
    }

    @Override
    public Boolean informPublishCommentEvent(Long orderId) {
        return null;
    }

    @Override
    public List<OrderInfoDto> listNotPublishedCommentOrders() {
        return null;
    }

    @Override
    public Boolean informBatchPublishCommentEvent(List<Long> orderIds) {
        return null;
    }
}
