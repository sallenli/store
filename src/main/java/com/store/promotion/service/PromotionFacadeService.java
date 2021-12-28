package com.store.promotion.service;

import com.store.promotion.domain.PromotionActivityDto;

import java.util.List;

/**
 * 促销中心对外暴露接口
 */
public interface PromotionFacadeService {
    /**
     * 查询商品促销活动
     * @param goodsId 商品id
     * @return 促销活动
     */
    List<PromotionActivityDto> ListPromotionActivitiesByGoodsId(Long goodsId);
}
