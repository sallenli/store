package com.store.promotion.service.Impl;

import com.store.common.utils.DateProvider;
import com.store.promotion.constant.DefaultPromotionActicity;
import com.store.promotion.domain.PromotionActivityDto;
import com.store.promotion.service.PromotionFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 促销中心对外暴露接口
 */
@Service
public class PromotionFacadeServiceImpl implements PromotionFacadeService {
    @Autowired
    DateProvider dateProvider;

    private static final Logger logger = LoggerFactory.getLogger(PromotionFacadeServiceImpl.class);
    @Override
    public List<PromotionActivityDto> ListPromotionActivitiesByGoodsId(Long goodsId) {
        List<PromotionActivityDto> list = new ArrayList<PromotionActivityDto>();
        try {
            PromotionActivityDto promotionActivityDto1 = new PromotionActivityDto();
            promotionActivityDto1.setGmtCreate(dateProvider.getCurrentTime());
            promotionActivityDto1.setPromotionActivityName("测试活动");
            promotionActivityDto1.setPromotionActivityEndTime("11111111");
            promotionActivityDto1.setPromotionActivityStatus(DefaultPromotionActicity.ENABLE);
            list.add(promotionActivityDto1);

            PromotionActivityDto promotionActivityDto2 = new PromotionActivityDto();
            promotionActivityDto2.setGmtCreate(dateProvider.getCurrentTime());
            promotionActivityDto2.setPromotionActivityName("测试活动2");
            promotionActivityDto2.setPromotionActivityEndTime("222222");
            promotionActivityDto2.setPromotionActivityStatus(DefaultPromotionActicity.ENABLE);
            list.add(promotionActivityDto2);
            return list;
        } catch (Exception e) {
            logger.error("PromotionFacadeServiceImpl.ListPromotionActivitiesByGoodsId",e.getMessage());
            return  new ArrayList<PromotionActivityDto>();
        }
    }
}
