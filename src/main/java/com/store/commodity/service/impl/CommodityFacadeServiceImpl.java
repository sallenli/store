package com.store.commodity.service.impl;

import com.store.commodity.domain.GoodsSkuDto;
import com.store.commodity.service.CommodityFacadeService;
import com.store.common.utils.DateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityFacadeServiceImpl implements CommodityFacadeService {
    private static final Logger logger = LoggerFactory.getLogger(CommodityFacadeServiceImpl.class);
    @Autowired
    DateProvider dateProvider;
    @Override
    public GoodsSkuDto getGoodsSkuById(Long GoodsSkuId) {
        try {
            GoodsSkuDto goodsSkuDto = new GoodsSkuDto();
            goodsSkuDto.setDiscount(100.00);
            goodsSkuDto.setGmtCreate(dateProvider.getCurrentTime());
            goodsSkuDto.setGmtModified(dateProvider.getCurrentTime());
            goodsSkuDto.setGoodsHeight(59.5);
            goodsSkuDto.setGrossWeight(52.2);
            goodsSkuDto.setSalesPirce(9999.0);
            return goodsSkuDto;
        } catch (Exception e) {
            logger.error("CommodityFacadeServiceImpl.getGoodsSkuById",e.getMessage());
            return new GoodsSkuDto();
        }
    }
}
