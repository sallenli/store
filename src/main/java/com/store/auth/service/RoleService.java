package com.store.auth.service;

import com.store.auth.domain.RoleDo;
import com.store.auth.domain.RoleDto;
import com.store.auth.domain.RoleQuery;

import java.util.List;

/**
 * service组件接口
 */
public interface RoleService {
    /**
     * 分页查询角色
     * @param roleQuery 查询条件
     * @return 角色DO集合
     */

    List<RoleDto> listByPage(RoleQuery roleQuery);

    /**
     * 根据id查询角色do对象
     * @param id
     * @return
     */

    RoleDto getById(Long id);

    /**
     * 添加角色
     * @param roleDto 角色dto
     */

    Boolean save(RoleDto roleDto);

    /**
     * 更新角色
     * @param roleDo
     */

    Boolean update(RoleDto roleDo);

    /**
     * 删除角色
     * @param id
     */

    Boolean  remove(Long id);
}
