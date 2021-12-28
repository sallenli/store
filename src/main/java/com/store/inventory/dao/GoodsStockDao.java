package com.store.inventory.dao;

import com.store.inventory.domain.GoodsStockDo;
import org.apache.ibatis.annotations.*;

/**
 * 商品库存管理模块dao接口
 */
public interface GoodsStockDao {

    /**
     * 根据商品sku id 查询商品库存
     * @param goodsSkuId 商品sku id
     * @return 商品库存
     */

    GoodsStockDo getGoodsStockBySkuId(Long goodsSkuId);

    /**
     * 新增商品库存
     * @param goodsStockDo  商品库存do对象
     */

    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    Long  saveGoodsStock(GoodsStockDo goodsStockDo);

    /**
     * 更新商品库存
     * @param goodsStockDo
     */

    Boolean  updateGoodsStock(GoodsStockDo goodsStockDo);
}
