package com.store.inventory.async;

import com.alibaba.fastjson.JSONObject;
import com.store.inventory.domain.StockUpdateMessageDo;

import java.util.List;

/**
 * 离线组件管理模块接口
 */
public interface OfflineStorageManager {
    /**
     * 离线存储库存更新消息
     * @param message  库存更新消息
     * @throws Exception
     */
     void store(StockUpdateMessage message) throws Exception;

     Boolean getOffline();
     void setOffline(Boolean offline);
    /**
     * 判断是否还有下一批库存更新消息
     * @return
     */
    Boolean hasNext();

    /**
     * 获取下一批库存更新消息
     * @return
     */
     List<StockUpdateMessage> getNextBatch() throws ClassNotFoundException;

    /**
     * 批量删除库存更新消息
     * @param stockUpdateMessages 库存更新消息
     * @throws Exception
     */
    public void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) throws Exception;

}
