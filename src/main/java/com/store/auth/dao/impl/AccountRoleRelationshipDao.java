package com.store.auth.dao.impl;

import org.apache.ibatis.annotations.Select;

/**
 * 账户角色关系管理模块dao
 */
public interface AccountRoleRelationshipDao {
    /**
     * 根据角色id查询记录数
     * @return
     */

    Long countByRoleId(Long roleId);

}
