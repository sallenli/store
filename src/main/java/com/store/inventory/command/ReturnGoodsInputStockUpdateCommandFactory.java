package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import com.store.wms.domain.PurchaseInputOrderDto;
import com.store.wms.domain.PurchaseInputOrderItemDto;
import com.store.wms.domain.ReturnGoodsInputOrderDto;
import com.store.wms.domain.ReturnGoodsInputOrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采购入库库存更新命令
 */
@Component
public class ReturnGoodsInputStockUpdateCommandFactory<T>  extends  AbstractGoodsStockUpdateCommandFactory<T>{



    /**构造函数直接注入spring,生成bean
     * @param goodsStockDao 商品库存管理模块的dao组件
     * @param dateProvider 日期辅助组件
     */
    @Autowired
    public ReturnGoodsInputStockUpdateCommandFactory(GoodsStockDao goodsStockDao, DateProvider dateProvider) {
        super(goodsStockDao, dateProvider);
    }

    /**
     * 获取商品sku id集合
     * @
     * @return 商品sku id集合
     * @throws Exception
     */
    @Override
    protected List<Long> getGoodsSkuIds(T obj) throws Exception {
        ReturnGoodsInputOrderDto returnGoodsInputOrderDto = (ReturnGoodsInputOrderDto) obj;
        List<ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtos = returnGoodsInputOrderDto.getReturnGoodsInputOrderItemDtoList();
        if(returnGoodsInputOrderItemDtos == null || returnGoodsInputOrderItemDtos.size() == 0){
            return  new ArrayList<Long>();
        }
        List<Long> goodsSkuIds = new ArrayList<Long>(returnGoodsInputOrderItemDtos.size());
        for(ReturnGoodsInputOrderItemDto returnGoodsInputOrderItemDto: returnGoodsInputOrderItemDtos){
            goodsSkuIds.add(returnGoodsInputOrderItemDto.getGoodsSkuId());
        }
        return goodsSkuIds;
    }
    /**
     * 创建库存更新命令
     * @param goodsStockDos 商品库存do对象
     * @return 商品库存更新命令
     * @throws Exception
     */
    @Override
    protected GoodsStockUpdateCommand create(List<GoodsStockDo> goodsStockDos,T obj) throws Exception {
        //解析采购入库单，获取采购入库单map
        ReturnGoodsInputOrderDto returnGoodsInputOrderDto = (ReturnGoodsInputOrderDto) obj;
        List<ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtos = returnGoodsInputOrderDto.getReturnGoodsInputOrderItemDtoList();
        Map <Long,ReturnGoodsInputOrderItemDto> returnGoodsInputOrderItemDtoMap = new HashMap<Long, ReturnGoodsInputOrderItemDto>();;
        if(returnGoodsInputOrderItemDtoMap != null && returnGoodsInputOrderItemDtoMap.size() > 0) {
            for (ReturnGoodsInputOrderItemDto returnGoodsInputOrderItemDto:returnGoodsInputOrderItemDtos) {
                returnGoodsInputOrderItemDtoMap.put(returnGoodsInputOrderItemDto.getGoodsSkuId(),returnGoodsInputOrderItemDto);
            }
        }
        //创建库存更新命令
        return new ReturnGoodsInputStockUpdateCommand(goodsStockDos,goodsStockDao,dateProvider,returnGoodsInputOrderItemDtoMap);

    }
}
