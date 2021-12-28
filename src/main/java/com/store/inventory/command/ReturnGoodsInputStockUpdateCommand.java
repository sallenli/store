package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import com.store.wms.domain.ReturnGoodsInputOrderItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 退货入库更新库存
 */

public class ReturnGoodsInputStockUpdateCommand extends AbstractGoodsStockUpdateCommand {

    /**
     * 退货入库单条目dto集合
     *
     */
    private Map<Long, ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtoMap;

    /**
     * constructor
     * @param goodsStockDos 商品库存do集合
     * @param goodsStockDao 商品库存管理模块 dao集合
     * @param dateProvider  日期辅助组件
     * @param returnGoodsInputOrderItemDtoMap 退货入库单条目dto集合
     */
    public ReturnGoodsInputStockUpdateCommand(List<GoodsStockDo> goodsStockDos,
                                              GoodsStockDao goodsStockDao,
                                              DateProvider dateProvider,
                                              Map<Long, ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtoMap) {
        super(goodsStockDos, goodsStockDao, dateProvider);
        this.returnGoodsInputOrderItemDtoMap = returnGoodsInputOrderItemDtoMap;
    }

    /**
     * 更新销售库存
     * @throws Exception
     */
    @Override
    protected void updateSaleStockQuantity() throws Exception {
        for (GoodsStockDo goodsStockDo: goodsStockDos) {
            ReturnGoodsInputOrderItemDto returnGoodsInputOrderItemDto = returnGoodsInputOrderItemDtoMap.get(goodsStockDo.getId());
            goodsStockDo.setSaleStockQuantity(goodsStockDo.getSaleStockQuantity()+returnGoodsInputOrderItemDto.getArrivalCount());
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

    /**
     * 更新库存状态
     * @throws Exception
     */
    @Override
    protected void updateStockStatus() throws Exception {

    }
}
