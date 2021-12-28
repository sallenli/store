package com.store.cart.domain;



import com.store.common.utils.BeanCopierUtils;
import com.store.promotion.domain.PromotionActivityDto;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * 购物车条目dto类
 */
@Data
public class ShoppingCartItemVo {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDo.class);
    private Long id;
    //购物车id
    private Long shoppingCartId;
    //商品sku id
    private Long goodsSkuId;
    //商品sku 编号
    private String GoodsSkuCode;
    //销售属性
    private String GoodsName;
    //销售属性
    private String saleProperties;
    //商品sku售价
    private Double salePrice;
    //商品毛重
    private Double grossWeight;
    //商品长度
    private Double goodsLength;
    //商品宽度
    private Double goodsWidth;
    //商品高度
    private Double goodsHeight;
    //销售库存
    private Long saleStockQuantity;
    //购买数量
    private Long purchaseQuantity;
    //商品id
    private Long goodsId;

    private Date gmtCreate;

    private Date gmtModified;
    //促销活动dto列表
    private List<PromotionActivityDto> promotionActivityDtoList;
    public <T> T clone(Class<T> clz){
        T target = null;
        try {
            target = clz.newInstance();
            BeanCopierUtils.copyProperties(this,target);
            return  target;
        } catch (Exception e) {
            logger.error("ShoppingCartDo.clone",e.getMessage());
            return null;
        }
    }
}
