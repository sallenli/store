package com.store.inventory.async;

/**
 * 商品库存更新结果管理组件
 */
public interface StockUpdateManager {
    /**
     * 设置对商品库存更新结果的观察
     * @param messageId 消息id
     */
    public void observe(String messageId);


    /**
     * 获取商品库存更新结果的观察目标
     * @param messageId 商品库存更新消息id
     */
    public void inform(String messageId,Boolean result);
}
