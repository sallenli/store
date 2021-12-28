package com.store.inventory.async;

/**
 * 商品库存更新消息队列 jvm内存队列
 */
public interface StockUpdateQueue {
    /**
     * 消息入列
     * @param message 消息
     * @throws Exception
     */
     void put(StockUpdateMessage message) throws Exception;

    /**
     * 消息出列
     * @return
     * @throws Exception
     */
     StockUpdateMessage get() throws Exception;

    void putDirect(StockUpdateMessage message) throws Exception;
}
