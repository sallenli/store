package com.store.inventory.async.impl;

import com.store.inventory.async.OfflineResumeThread;
import com.store.inventory.async.OfflineStorageManager;
import com.store.inventory.async.StockUpdateMessage;
import com.store.inventory.async.StockUpdateQueue;
import com.store.inventory.dao.StockUpdateMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.util.concurrent.ArrayBlockingQueue;
@Component
public class StockUpdateQueueImpl implements StockUpdateQueue {

    private static final Integer QUEUE_MAX_SIZE = 1000;
    //商品库存更新队列
    private ArrayBlockingQueue<StockUpdateMessage> queue = new ArrayBlockingQueue<StockUpdateMessage>(1000);

    @Autowired
    private StockUpdateMessageDao stockUpdateMessageDao;
    @Autowired
    OfflineStorageManager offlineStorageManager;

    /**
     * 消息入列
     * @param message
     * @throws Exception
     */
    public void put(StockUpdateMessage message) throws Exception{
        //每次网内存队列放消息之前，先检查离线存储标示
        //触发离线存储，直接写离线存储
        //写完离线存储以后，需要检查内存队列大小，内存队列清零，启动后台线程
        //让后台线程去将离线存储中的数据恢复写入队列
        if(offlineStorageManager.getOffline()){
            offlineStorageManager.store(message);
            if(queue.size() == 0 ){
                new OfflineResumeThread(offlineStorageManager,this).start();
            }
            return;
        }
        //如果内存队列已经满了，触发离线存储
        if(QUEUE_MAX_SIZE.equals(queue.size())){
            offlineStorageManager.store(message);
            offlineStorageManager.setOffline(true);
            return;
        }
        queue.put(message);
    }

    /**
     * 消息出列
     * @return
     * @throws Exception
     */
    public StockUpdateMessage get() throws Exception{
          return queue.take();
    }

    /**
     * 直接将消息写入队列
     * @param message
     * @throws Exception
     */
    @Override
    public void putDirect(StockUpdateMessage message) throws Exception {
        queue.put(message);
    }

}
