package com.store.inventory.async;

import java.util.Observable;

/**
 * 商品库存更新结果观察目标 被观察者
 */

public class StockUpdateObservable extends Observable {
    /**
     * 消息id
     */
    private String messageId;

    public StockUpdateObservable(String messageId){
        this.messageId = messageId;
    }
    /**
     * 设置商品库存更新结果
     * @param result  商品库存更新结果
     */
    public void setResult( Boolean result){
        StockUpdateResult stockUpdateResult = new StockUpdateResult();
        stockUpdateResult.setMessageId(messageId);
        stockUpdateResult.setResult(result);

        this.setChanged();
        //结果推送
        this.notifyObservers(stockUpdateResult);
    }

    public String getMessageId() {
        return messageId;
    }
}
