package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.constant.DefaultInventoryConstant;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.PurchaseInputOrderItemDto;

import java.util.List;
import java.util.Map;


/**
 * 采购入库库存更新command
 */
public class PurchaseInputStockUpdateCommand  extends  AbstractGoodsStockUpdateCommand{
    /**
     * 采购入库单dto
     */
   // private PurchaseInputOrderDto purchaseInputOrderDto;
    /**
     * 采购入库单条目map
     */
    private Map<Long, PurchaseInputOrderItemDto> purchaseInputOrderItemDtoMap;
    /**
     * 构造函数
     * @param goodsStockDos 商品库存do对象
     * @param goodsStockDao 商品库存管理模块dao组件
     * @param dateProvider 日期
     */
    public PurchaseInputStockUpdateCommand(List<GoodsStockDo> goodsStockDos,
                                           GoodsStockDao goodsStockDao,
                                           DateProvider dateProvider,
                                           Map<Long, PurchaseInputOrderItemDto> purchaseInputOrderItemDtoMap) {
        super(goodsStockDos, goodsStockDao, dateProvider);

        this.purchaseInputOrderItemDtoMap = purchaseInputOrderItemDtoMap;
    }



    /**
     * 更新销售库存
     * @throws Exception
     */
    @Override
    protected void updateSaleStockQuantity() throws Exception {
        for (GoodsStockDo goodsStockDo:goodsStockDos) {
            PurchaseInputOrderItemDto purchaseInputOrderItemDto = purchaseInputOrderItemDtoMap.get(goodsStockDo.getId());
            goodsStockDo.setSaleStockQuantity(goodsStockDo.getSaleStockQuantity()+purchaseInputOrderItemDto.getArrivalCount());
        }
    }

    /**
     * 更新锁定库存
     * @throws Exception
     */
    @Override
    protected void updateLockedStockQuantity() throws Exception {

    }

    /**
     * 更新已销售库存
     * @throws Exception
     */
    @Override
    protected void updateSaledStockQuantity() throws Exception {

    }


}
