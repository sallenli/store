package com.store.inventory.dao;

import com.store.inventory.domain.StockUpdateMessageDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 库存更新管理模块dao
 */
public interface StockUpdateMessageDao {
    /**
     * 新增库存消息
     * @param stockUpdateMessageDo 库存更新消息do对象
     * @return
     */
    Boolean saveOfflineStockUpdateMessage(StockUpdateMessageDo stockUpdateMessageDo);


    /**
     * 批量查询库存更新消息，每次50条
     * @return 库存更新消息do对象集合
     */

    List<StockUpdateMessageDo> listByBatch();

    /**
     * 批量删除库存更新消息
     * @param messageIds 库存更新消息id
     * @return
     */

    Boolean removeByBatch(String messageIds);


    /**
     * 查询库存更新消息记录数
     * @return
     */
    Long count();
}
