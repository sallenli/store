package com.store.inventory.async.impl;

import com.store.inventory.async.StockUpdateObservable;

import com.store.inventory.async.StockUpdateManager;
import com.store.inventory.async.StockUpdateObserver;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UpdateManagerImpl implements StockUpdateManager {
    /**
     * 商品库存更新结果观察者
     */
    private StockUpdateObserver observer;
    /**
     * 商品库存更新结果map
     */
    private Map<String, StockUpdateObservable> observableMap = new ConcurrentHashMap<>();

    /**
     * 设置对商品库存更新结果的观察
     * @param messageId 消息id
     */
    public void observe(String messageId){
        StockUpdateObservable observable = new StockUpdateObservable(messageId);
        observable.addObserver(observer);
        observableMap.put(messageId,observable);

    }

    /**
     * 获取商品库存更新结果的观察目标
     * @param messageId 商品库存更新消息id
     */
    public void inform(String messageId,Boolean result){
        StockUpdateObservable stockUpdateObservable = observableMap.get(messageId);
        stockUpdateObservable.setResult(result);
        //移除观察目标
        observableMap.remove(messageId);
    }
}
