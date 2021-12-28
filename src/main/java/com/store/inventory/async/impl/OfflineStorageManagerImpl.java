package com.store.inventory.async.impl;

import com.alibaba.fastjson.JSONObject;
import com.store.common.utils.DateProvider;
import com.store.inventory.async.OfflineStorageManager;
import com.store.inventory.async.StockUpdateMessage;
import com.store.inventory.dao.StockUpdateMessageDao;
import com.store.inventory.domain.StockUpdateMessageDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfflineStorageManagerImpl implements OfflineStorageManager {
    /**
     * 库存更新消息管理模块dao
     */
    @Autowired
    private StockUpdateMessageDao stockUpdateMessageDao;

    @Autowired
    private DateProvider dateProvider;
    /**
     * 是否触发离线存储
     */
    private Boolean offline = false;
    /**
     * 离线存储库存更新消息
     * @param message  库存更新消息
     * @throws Exception
     */
    public void store(StockUpdateMessage message) throws Exception{
            StockUpdateMessageDo stockUpdateMessageDo = createStockUpdateMessageDo(message);
            stockUpdateMessageDao.saveOfflineStockUpdateMessage(stockUpdateMessageDo);

    }

    /**
     * 创建库存更新消息do对象
     * @param message 库存更新消息
     * @return 库存更新消息do对象
     * @throws Exception
     */
    private StockUpdateMessageDo createStockUpdateMessageDo(StockUpdateMessage message) throws Exception{
        StockUpdateMessageDo stockUpdateMessageDo = new StockUpdateMessageDo();
        stockUpdateMessageDo.setMessageId(message.getId());
        stockUpdateMessageDo.setOperation(message.getOperation());
        stockUpdateMessageDo.setParameter(JSONObject.toJSONString(message.getParameter()));
        stockUpdateMessageDo.setParameterClazz(message.getParameter().getClass().getName());
        stockUpdateMessageDo.setGmtCreate(dateProvider.getCurrentTime());
        stockUpdateMessageDo.setGmtModified(dateProvider.getCurrentTime());
        return stockUpdateMessageDo;

    }


    public  Boolean getOffline(){
        return  this.offline;
    }
    public void setOffline(Boolean offline){
        this.offline = offline;
    }

    /**
     * 判断是否还有下一批库存更新消息
     * @return
     */
    public  Boolean hasNext(){
            return stockUpdateMessageDao.count().equals(0L)?false : true;
    }

    /**
     * 获取下一批内存更新消息
     * @return
     */
    @Override
    public List<StockUpdateMessage> getNextBatch() throws ClassNotFoundException {

            List<StockUpdateMessage> stockUpdateMessages = new ArrayList<>();
            List<StockUpdateMessageDo> stockUpdateMessageDos = stockUpdateMessageDao.listByBatch();
            for (StockUpdateMessageDo stockUpdateMessageDo : stockUpdateMessageDos) {
                StockUpdateMessage stockUpdateMessage = new StockUpdateMessage();
                stockUpdateMessage.setId(stockUpdateMessageDo.getMessageId());
                stockUpdateMessage.setOperation(stockUpdateMessageDo.getOperation());
                stockUpdateMessage.setParameter(JSONObject.parseObject(stockUpdateMessageDo.getParameter(),
                        Class.forName(stockUpdateMessageDo.getParameterClazz())));
                stockUpdateMessages.add(stockUpdateMessage);
            }
            return stockUpdateMessages;

        }

    /**
     * 批量删除库存更新消息
     * @param stockUpdateMessages 库存更新消息
     * @throws Exception
     */
    public void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) throws Exception{
        StringBuilder builder = new StringBuilder("");
        for(int i = 0; i < stockUpdateMessages.size(); i++){
            builder.append(stockUpdateMessages.get(i).getId());
            if(i<stockUpdateMessages.size() - 1){
                builder.append(",");
            }
        }
        stockUpdateMessageDao.removeByBatch(builder.toString());
    }


}
