package com.store.inventory.async;

import com.store.inventory.dao.StockUpdateMessageDao;
import com.store.inventory.domain.StockUpdateMessageDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 离线数据恢复线程
 */
public class OfflineResumeThread extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(OfflineResumeThread.class);
    /**
     * 离线存储管理组件
     */
    private OfflineStorageManager offlineStorageManager;
    /**
     * 库存更新队列
     */
    private StockUpdateQueue stockUpdateQueue;

    public OfflineResumeThread(OfflineStorageManager offlineStorageManager,StockUpdateQueue stockUpdateQueue){
        this.offlineStorageManager = offlineStorageManager;
        this.stockUpdateQueue = stockUpdateQueue;
    }

    /**
     * 执行线程
     */
    public  void run(){
        //判断表中是否还有数据
        while (offlineStorageManager.hasNext()){
            //每次从Mysql批量查询50条数据,批量处理数据
            try {
                List<StockUpdateMessage> stockUpdateMessageDoList = offlineStorageManager.getNextBatch();
                //将一批数据写入内存队列
                for(StockUpdateMessage stockUpdateMessage : stockUpdateMessageDoList){
                    stockUpdateQueue.put(stockUpdateMessage);
                }
                //批量删除一批数据
                offlineStorageManager.removeByBatch(stockUpdateMessageDoList);
            } catch (Exception e) {
                logger.error("OfflineResumeThread",e.getMessage());
            }

        }
        //mysqal 数据全部恢复完，更新内存标示
        offlineStorageManager.setOffline(false);
    }
}
