package com.store.cart.domain;



import com.store.common.utils.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Objects;
//购物车do

public class ShoppingCartDo {
    private static  final Logger logger = LoggerFactory.getLogger(ShoppingCartDo.class);
    //主键id
    private Long id;
    //用户id
    private Long userAccountId;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartDo that = (ShoppingCartDo) o;
        return Objects.equals(id, that.id) && Objects.equals(userAccountId, that.userAccountId) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAccountId, gmtCreate, gmtModified);
    }

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
