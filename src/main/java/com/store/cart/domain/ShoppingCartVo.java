package com.store.cart.domain;


import com.store.common.utils.BeanCopierUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 购物车表现层参数
 */
@Data
public class ShoppingCartVo {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDo.class);
    //用户账号id
    private Long userAccountId;
    //商品skuId
    private Long goodSkuId;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;
    //购物车条目集合
    List<ShoppingCartItemVo> shoppingCartItemVoList;
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
