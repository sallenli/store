package com.store.auth.dao;

import com.store.auth.domain.PriorityDo;

import java.util.List;

/**
 * 权限管理模块dao接口
 */
public interface PriorityDAO {
    /**
     * 查询根权限列表
     * @return  根权限列表
     */
    List<PriorityDo> listRootPriorities();

    /**
     * 根据父权限，查询子权限
     * @param parentId
     * @return
     */
    List<PriorityDo>  listChildPriorities( Long parentId);
    /**
     * 新增权限
     * @param priorityDo 权限do对象
     * @return 返回插入id
     */
    Long savePriority(PriorityDo priorityDo);
    /**
     * 根据id查询
     * @param id 权限id
     * @return 返回权限
     */
    PriorityDo getPriorityById( Long id);
    /**
     * 更新权限
     * @param priorityDo 权限do对象
     *
     */
    Boolean updatePriority(PriorityDo priorityDo);

    /**
     * 删除权限
     * @param id 权限id
     * @return
     */
    Boolean removePriority(Long id);
}
