package com.store.inventory.dao.impl;

import com.store.inventory.Mapper.StockUpdateMessageMapper;
import com.store.inventory.dao.StockUpdateMessageDao;
import com.store.inventory.domain.StockUpdateMessageDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockUpdateMessageDaoImpl implements StockUpdateMessageDao {
    private static final Logger logger = LoggerFactory.getLogger(StockUpdateMessageDaoImpl.class);
    @Autowired
    private StockUpdateMessageMapper stockUpdateMessageMapper;

    /**
     * 新增库存消息
     * @param stockUpdateMessageDo 库存更新消息do对象
     * @return
     */
    @Override
    public Boolean saveOfflineStockUpdateMessage(StockUpdateMessageDo stockUpdateMessageDo) {
        try {
            stockUpdateMessageMapper.saveOfflineStockUpdateMessage(stockUpdateMessageDo);
            return  true;
        } catch (Exception e) {
            logger.error("StockUpdateMessageDaoImpl.saveOfflineStockUpdateMessage",e.getMessage());
            return false;
        }
    }

    @Override
    public List<StockUpdateMessageDo> listByBatch() {
        try {
            return stockUpdateMessageMapper.listByBatch();
        } catch (Exception e) {
            logger.error("StockUpdateMessageDaoImpl.listByBatch",e.getMessage());
            return  null;
        }
    }

    @Override
    public Boolean removeByBatch(String messageIds) {
        try {
            stockUpdateMessageMapper.removeByBatch(messageIds);
            return true;
        } catch (Exception e) {
            logger.error("StockUpdateMessageDaoImpl.removeByBatch",e.getMessage());
            return false;
        }
    }

    @Override
    public Long count() {
        try {
            return stockUpdateMessageMapper.count();
        } catch (Exception e) {
            logger.error("StockUpdateMessageDaoImpl.count",e.getMessage());
            return 0L;
        }
    }
}
