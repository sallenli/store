package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.constant.DefaultInventoryConstant;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractGoodsStockUpdateCommandFactory<T> implements GoodsStockUpdateCommandFactory<T>{

    private static final Logger logger = LoggerFactory.getLogger(AbstractGoodsStockUpdateCommandFactory.class);
    protected GoodsStockDao goodsStockDao;
    protected DateProvider dateProvider;
    /**
     *
     * @param goodsStockDao 商品库存管理模块的dao组件
     */
   public  AbstractGoodsStockUpdateCommandFactory(GoodsStockDao goodsStockDao,
                                                  DateProvider dateProvider){
       this.goodsStockDao = goodsStockDao;
       this.dateProvider = dateProvider;
   }

    /**
     * 创建商品库存do对象集合
     * @param goodsSkuIds 商品sku id集合
     * @return 商品库存do对象集合
     */
    protected List<GoodsStockDo> createGoodsStockDos(List<Long> goodsSkuIds) throws Exception {
        ArrayList<GoodsStockDo> goodsStockDos = new ArrayList<>(goodsSkuIds.size());
        for(Long goodsSkuId : goodsSkuIds){

            GoodsStockDo goodsStock = goodsStockDao.getGoodsStockBySkuId(goodsSkuId);
            if(goodsStock == null){
                goodsStock = new GoodsStockDo();
                goodsStock.setGoodsSkuId(goodsSkuId);
                goodsStock.setSaleStockQuantity(0L);
                goodsStock.setLockedStockQuantity(0L);
                goodsStock.setStockStatus(DefaultInventoryConstant.NOT_IN_STOCK);
                goodsStock.setGmtCreate(dateProvider.getCurrentTime());
                goodsStock.setGmtModified(dateProvider.getCurrentTime());

                goodsStockDao.saveGoodsStock(goodsStock);
            }
            goodsStockDos.add(goodsStock);
        }
        return goodsStockDos;
    }

    /**
     * 创建库存更新命令
     * @param obj 参数对象
     * @return
     */
    @Override
    public GoodsStockUpdateCommand create(T obj) {
        try {
            List<Long> goodsSkuId = getGoodsSkuIds(obj);
            List<GoodsStockDo> goodsStockDos = createGoodsStockDos(goodsSkuId);
            return create(goodsStockDos,obj);
        } catch (Exception e) {
            logger.error("AbstractGoodsStockUpdateCommandFactory.GoodsStockUpdateCommand",e.getMessage());
        }
        return null;
    }

    /**
     * 获取商品sku id集合
     * @return
     * @throws Exception
     */
    protected  abstract List<Long> getGoodsSkuIds(T obj) throws  Exception;

    /**
     * 创建库存更新命令
     * @param goodsStockDos 商品库存do对象
     * @return 商品库存更新命令
     * @throws Exception
     */
    protected  abstract  GoodsStockUpdateCommand create(List<GoodsStockDo> goodsStockDos,T obj) throws  Exception;
}
