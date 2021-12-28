package com.store.inventory.command;

import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;

import java.util.List;

/**
 * 库存更新命令的创建工厂
 */
public interface GoodsStockUpdateCommandFactory <T> {

    /**
     * 创建一个库存更新命令
     * @param obj 参数对象
     * @return 库存更新命令
     */
 GoodsStockUpdateCommand create(T obj);

}
