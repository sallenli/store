package com.store.inventory.command;

import com.store.common.utils.DateProvider;
import com.store.inventory.constant.DefaultInventoryConstant;
import com.store.inventory.dao.GoodsStockDao;
import com.store.inventory.domain.GoodsStockDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 商品库存更新命令抽象基类
 */
public abstract  class AbstractGoodsStockUpdateCommand implements GoodsStockUpdateCommand {

    private static final Logger logger = LoggerFactory.getLogger(AbstractGoodsStockUpdateCommand.class);
    /**
     * 商品库存do对象
     */
    protected List<GoodsStockDo> goodsStockDos;
    protected GoodsStockDao goodsStockDao;
    protected DateProvider dateProvider;

    public AbstractGoodsStockUpdateCommand(List<GoodsStockDo> goodsStockDos,GoodsStockDao goodsStockDao ,DateProvider dateProvider){
        this.goodsStockDos = goodsStockDos;
        this.goodsStockDao = goodsStockDao;
        this.dateProvider = dateProvider;
    }
    /**
     * 更新商品库存
     * @return
     */
    public Boolean updateGoodsStock(){
        try {
            updateSaleStockQuantity();
            updateLockedStockQuantity();
            updateSaledStockQuantity();
            updateStockStatus();
            updateGmtModified();
            executeUpdateGoodsStock();
            return true;
        } catch (Exception e) {
            logger.error("AbstractGoodsStockUpdaterCommand.updateGoodsStock",e.getMessage());
            return false;
        }
    }

    /**
     * 更新商品的销售库存
     */
    protected  abstract void updateSaleStockQuantity() throws Exception;

    /**
     * 更新商品的锁定库存
     */
    protected  abstract  void updateLockedStockQuantity() throws Exception;

    /**
     * 更新商品的已销售库存
     */
    protected abstract void updateSaledStockQuantity() throws  Exception;

    /**
     * 更新商品的库存状态
     */
    /**
     * 更新库存状态
     * @throws Exception
     */

    protected void updateStockStatus() throws Exception {
        for(GoodsStockDo goodsStockDo:goodsStockDos){
            if(goodsStockDo.getSaleStockQuantity() > 0L){
                goodsStockDo.setStockStatus(DefaultInventoryConstant.IN_STOCK);
            }
            else {
                goodsStockDo.setStockStatus(DefaultInventoryConstant.NOT_IN_STOCK);
            }
        }
    }

    /**
     * 更新库存修改时间
     * @throws Exception
     */
    private void  updateGmtModified() throws Exception{
        for (GoodsStockDo goodsStockDo:goodsStockDos) {
            goodsStockDo.setGmtModified(dateProvider.getCurrentTime());
        }

    }

    /**
     * 实际执行更新商品库存的操作
     * @throws Exception
     */
    private void executeUpdateGoodsStock() throws Exception{
        for (GoodsStockDo goodsStockDo:goodsStockDos) {
            goodsStockDao.updateGoodsStock(goodsStockDo);
        }

    }
}
