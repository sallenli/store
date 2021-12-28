package com.store.common.utils;

import java.util.ArrayList;
import java.util.List;

public class ObjectUtils {
    /**
     * 转换集合
     * @param  sourceList 原数据集合
     * @param targetclz 目标集合元素类型
     * @param <T> 转换后的集合
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T>  convertList(List<? extends AbstractObject> sourceList,Class<T> targetclz) throws Exception{
        List<T> targetList = new ArrayList<T>();
        sourceList.forEach((AbstractObject obj)->{
            try {
                targetList.add(obj.clone(targetclz));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return targetList;
    }
}
