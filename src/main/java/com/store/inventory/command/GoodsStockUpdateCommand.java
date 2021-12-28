package com.store.inventory.command;

/**
 * 商品库存更新命令接口
 */
public interface GoodsStockUpdateCommand {
    /**
     * 更新商品库存
     * @return
     */
    Boolean updateGoodsStock();
}
