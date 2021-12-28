package com.store.inventory.service.impl;

import com.store.inventory.async.StockUpdateManager;
import com.store.inventory.async.StockUpdateMessage;
import com.store.inventory.async.StockUpdateQueue;
import com.store.inventory.command.*;
import com.store.inventory.constant.DefaultInventoryConstant;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import com.store.inventory.service.InventoryFacadeService;
import com.store.order.domain.OrderInfoDto;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryFacadeServiceImpl implements InventoryFacadeService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryFacadeServiceImpl.class);

    /**
     * 采购入库库存更新工厂
     */
    @Autowired
    private PurchaseInputStockUpdateCommandFactory<PurchaseInputOrderDto>  purchaseInputStockUpdateCommandFactory;

    /**
     * 退货入库更新命令工厂
     */
    @Autowired
    private ReturnGoodsInputStockUpdateCommandFactory<ReturnGoodsInputOrderDto> returnGoodsInputStockUpdateCommandFactory;
    /**
     * 提交订单命令更新工厂
     */
    @Autowired
    private SubmitOrderStockUpdaterFactory<OrderInfoDto> submitOrderStockUpdaterFactory;
    /**
     * 支付订单命令更新工厂
     */
    @Autowired
    private PayOrderStockUpdaterFactory<OrderInfoDto> payOrderStockUpdaterFactory;
    /**
     * 取消订单命令更新工厂
     */
    @Autowired
    private CancelOrderStockUpdaterFactory<OrderInfoDto> cancelOrderStockUpdaterFactory;

    /**
     * 商品库存管理模块dao
     */
    @Autowired
    private GoodsStockDao goodsStockDao;

    @Autowired
    private StockUpdateQueue stockUpdateQueue;
    //商品库存更新管理组件
    @Autowired
    private StockUpdateManager stockUpdateManager;
    /**
     *
     * 通知库存中心，采购入库完成
     *
     * @param purchaseInputOrderDto 采购入库单dto
     * @return
     */
    @Override
    public Boolean informPurchaseInputFinished(PurchaseInputOrderDto purchaseInputOrderDto) {

        try {
            GoodsStockUpdateCommand goodsStockUpdateCommand = purchaseInputStockUpdateCommandFactory.create(purchaseInputOrderDto);
            goodsStockUpdateCommand.updateGoodsStock();
            return  true;
        } catch (Exception e) {
            logger.error("InventoryFacadeServiceImpl.informPurchaseInputFinished",e.getMessage());
            return false;
        }

    }

    /**
     * 通知库存中心,订单提交完成
     *
     * @param orderDto 订单dto
     * @return
     */
    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDto orderDto) {
        try {
            //更新本地库存
            GoodsStockUpdateCommand goodsStockUpdateCommand = submitOrderStockUpdaterFactory.create(orderDto);
            goodsStockUpdateCommand.updateGoodsStock();

            //把提交订单的消息放入消息队列
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString().replace("-",""));
            message.setOperation(DefaultInventoryConstant.SUBMIT_ORDER);
            message.setParameter(orderDto);
            stockUpdateQueue.put(message);

            //监听异步处理结果
            stockUpdateManager.observe(message.getId());
            return true;
        } catch (Exception e) {
            logger.error("InventoryFacadeServiceImpl.informSubmitOrderEvent",e.getMessage());
            return false;
        }
    }

    /**
     * 通知库存中心，支付订单事件完成
     *
     * @param orderDto
     * @return
     */
    @Override
    public Boolean informPayOrderEvent(OrderInfoDto orderDto) {
        try {
            //更新本地库存

            GoodsStockUpdateCommand goodsStockUpdateCommand = payOrderStockUpdaterFactory.create(orderDto);
            goodsStockUpdateCommand.updateGoodsStock();
            //把支付订单的消息放入消息队列
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString().replace("-",""));
            message.setOperation(DefaultInventoryConstant.PAY_ORDER);
            message.setParameter(orderDto);
            stockUpdateQueue.put(message);




            //监听异步处理结果
            stockUpdateManager.observe(message.getId());
            return true;
        } catch (Exception e) {
            logger.error("InventoryFacadeServiceImpl.informPayOrderEvent",e.getMessage());
            return false;
        }
    }

    /**
     * 通知库存中心，取消订单事件
     *
     * @param orderDto 订单dto
     * @return
     */
    @Override
    public Boolean informCancelOrderEvent(OrderInfoDto orderDto) {
        try {
            //更新本地库存

            GoodsStockUpdateCommand goodsStockUpdateCommand = cancelOrderStockUpdaterFactory.create(orderDto);
            goodsStockUpdateCommand.updateGoodsStock();
            //把取消订单的消息放入消息队列
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString().replace("-",""));
            message.setOperation(DefaultInventoryConstant.Cancel_ORDER);
            message.setParameter(orderDto);
            stockUpdateQueue.put(message);
            //监听异步处理结果
            stockUpdateManager.observe(message.getId());
            return true;
        } catch (Exception e) {
            logger.error("InventoryFacadeServiceImpl.informCancelOrderEvent",e.getMessage());
            return false;
        }
    }

    /**
     * 通知库存中心，退货入库事件发生
     *
     * @param returnGoodsInputOrderDto 退货入库单dto
     * @return
     */
    @Override
    public Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDto returnGoodsInputOrderDto) {
        try {
            GoodsStockUpdateCommand goodsStockUpdateCommand = returnGoodsInputStockUpdateCommandFactory.create(returnGoodsInputOrderDto);
            goodsStockUpdateCommand.updateGoodsStock();
            return true;
        } catch (Exception e) {
            logger.error("InventoryFacadeServiceImpl.informReturnGoodsInputFinished",e.getMessage());
            return false;
        }

    }

    /**
     * 查询商品sku的库存
     *
     * @param goodsSkuId 商品skuid
     * @return
     */
    @Override
    public Long getSaleStockQuantity(Long goodsSkuId) {
        try {
            GoodsStockDo goodsStockDo = goodsStockDao.getGoodsStockBySkuId(goodsSkuId);
            if(goodsStockDo == null){
                return 0L;
            }
            return goodsStockDo.getSaleStockQuantity();
        } catch (Exception e) {
            logger.error("InventoryFacadeServiceImpl.getSaleStockQuantity",e.getMessage());
            return 0l;
        }
    }
}
