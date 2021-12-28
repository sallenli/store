package com.store.common.utils;

/**
 * 基础抽象类
 */
public class AbstractObject {

    public  <T> T clone (Class<T> clz) throws Exception{
        T target = clz.newInstance();
        BeanCopierUtils.copyProperties(this,target);
        return  target;
    }

}
