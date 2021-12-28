package com.store.inventory.async;

import com.store.order.domain.OrderInfoDto;
import lombok.Data;

/**
 * 商品库存更新消息
 */
@Data
public class StockUpdateMessage {
    //消息的标识id
    private String id;
    //商品库存更新操作
    private Integer operation;
    //核心数据
    private Object parameter;
}
