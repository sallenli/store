package com.store.inventory.async;

import lombok.Data;

/**
 * 商品库存更新结果
 */
@Data
public class StockUpdateResult {
    //商品库存更新消息id
    private String messageId;
    //商品库存更新结果
    private Boolean result;

}
