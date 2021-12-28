package com.store.auth.service;


import com.store.auth.domain.PriorityDo;
import com.store.auth.domain.PriorityDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块service
 */
public interface PriorityService {
    /**
     * 查询根权限列表
     * @return  根权限列表
     */
    List<PriorityDto> listRootPriorities();
    /**
     * 根据父权限，查询子权限
     * @param parentId
     * @return
     */
    List<PriorityDto> listChildPriorities( Long parentId);
    /**
     * 新增权限
     * @param priorityDto 权限do对象
     * @return 返回插入id
     */
    Long savePriority(PriorityDto priorityDto);
    /**
     * 根据id查询
     * @param id 权限id
     * @return 返回权限
     */
    PriorityDto getPriorityById( Long id);
    /**
     * 更新权限
     * @param priorityDto 权限do对象
     *
     */
    Boolean updatePriority(PriorityDto priorityDto);

    /**
     * 删除权限
     * @param id 权限id
     * @return
     */
    Boolean removePriority(Long id);
}
