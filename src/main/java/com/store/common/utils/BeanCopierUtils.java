package com.store.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据拷贝util
 *
 *
 */
public class BeanCopierUtils {

    public static final Map<String, BeanCopier> beanCopierCacheMap= new HashMap<>();

    /**
     *
     * @param source 元数据对象
     * @param target  目标数据对象
     */
    public static void copyProperties(Object source,Object target){
        String  cacheKey = source.getClass().toString()+target.getClass().toString();
        BeanCopier beanCopier = null;
        if(!beanCopierCacheMap.containsKey(cacheKey)){
            synchronized (BeanCopierUtils.class) {
                if(!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                }
            }
        }
        else {
            beanCopier=beanCopierCacheMap.get(cacheKey);
        }

        beanCopier.copy(source,target,null);

    }

}
