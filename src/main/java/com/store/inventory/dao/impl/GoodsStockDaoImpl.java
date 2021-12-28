package com.store.inventory.dao.impl;

import com.store.inventory.Mapper.GoodsStockMapper;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 商品库存管理模块dao接口
 */
@Repository
public class GoodsStockDaoImpl implements GoodsStockDao {

    private static final Logger logger = LoggerFactory.getLogger(GoodsStockDaoImpl.class);
    @Autowired
    private GoodsStockMapper goodsStockMapper;
    @Override
    public GoodsStockDo getGoodsStockBySkuId(Long goodsSkuId) {
        try {
            return goodsStockMapper.getGoodsStockBySkuId(goodsSkuId);
        } catch (Exception e) {
            logger.error("GoodsStockDaoImpl.getGoodsStockBySkuId",e.getMessage());
            return  null;
        }

    }

    @Override
    public Long saveGoodsStock(GoodsStockDo goodsStockDo) {
        try {
            return goodsStockMapper.saveGoodsStock(goodsStockDo);
        } catch (Exception e) {
            logger.error("GoodsStockDaoImpl.saveGoodsStock",e.getMessage());
            return 0L;
        }
    }

    @Override
    public Boolean updateGoodsStock(GoodsStockDo goodsStockDo) {
        try {
            goodsStockMapper.updateGoodsStock(goodsStockDo);
            return true;
        } catch (Exception e) {
            logger.error("GoodsStockDaoImpl.updateGoodsStock",e.getMessage());
            return false;
        }
    }
}
