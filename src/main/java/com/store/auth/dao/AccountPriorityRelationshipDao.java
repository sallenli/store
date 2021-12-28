package com.store.auth.dao;

import com.store.auth.domain.AccountPriorityRelationshipDo;
import org.apache.ibatis.annotations.Param;

/**
 * 账号和权限关系管理Dao组件接口
 */
public interface AccountPriorityRelationshipDao {
    /**
     * 根据ID查询关联的账号数量
     *
     * @param priorityId 权限ID
     * @return 账号数量
     */
    Long countByPriorityId(@Param("priorityId") Long priorityId);

    /**
     * 插入账号和权限之间关系
     *
     * @param accountPriorityRelationshipDo
     * @return
     */

    Boolean saveAccountPriorityRelationship(AccountPriorityRelationshipDo accountPriorityRelationshipDo);
}