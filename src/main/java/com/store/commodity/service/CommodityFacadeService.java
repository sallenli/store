package com.store.commodity.service;

import com.store.commodity.domain.GoodsSkuDto;

/**
 * @BeanInfo 商品中心对外接口
 * @author  sallen
 */
public interface CommodityFacadeService {
    /**
     * 根据商品ID查询
     * @param GoodsSkuId
     * @return
     */
    GoodsSkuDto getGoodsSkuById(Long GoodsSkuId);

    //o> listGoodsSku(G);
}
