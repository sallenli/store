package com.store.logistics.service;

import com.store.commodity.domain.GoodsSkuDto;

/**
 * 物流中心对外暴露接口
 */
public interface LogisticsFacadeService {
    /**
     * 计算运费
     * @param goodsSkuDto 商品sku dto
     * @return
     */
    Double calculateFreight(GoodsSkuDto goodsSkuDto);

}
