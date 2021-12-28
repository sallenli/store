package com.store.auth.dao;

import com.store.auth.domain.RoleDo;
import com.store.auth.domain.RoleQuery;


import java.util.List;

/**
 * 角色管理模块dao组件api
 */
public interface RoleDao {


        /**
         * 分页查询角色
         * @param roleQuery 查询条件
         * @return 角色DO集合
         */

        List<RoleDo> listByPage(RoleQuery roleQuery);

        /**
         * 根据id查询角色do对象
         * @param id
         * @return
         */

        RoleDo getById(Long id);

        /**
         * 添加角色
         * @param roleDo 角色do
         */

        Boolean save(RoleDo roleDo);

        /**
         * 更新角色
         * @param roleDo
         */

        Boolean update(RoleDo roleDo);

        /**
         * 删除角色
         * @param id
         */

        Boolean  remove(Long id);


}
