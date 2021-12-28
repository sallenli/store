package com.store.auth.dao;

import com.store.auth.domain.AccountPriorityRelationshipDo;
import com.store.auth.domain.RolePriorityRelationshipDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色和权限关系管理Dao组件接口
 */
public interface RolePriorityRelationshipDao {
    /**
     * 根据ID查询关联的角色数量
     * @param priorityId 权限ID
     * @return 角色数量
     */
    Long countByPriorityId(@Param("priorityId")Long priorityId );

    /**
     * 插入角色和权限之间关系
     *
     * @param rolePriorityRelationshipDo
     * @return
     */

    Boolean saveRolePriorityRelationship(RolePriorityRelationshipDo rolePriorityRelationshipDo);


    /**
     * 根据角色id查询角色和权限关系
     * @param roleId
     * @return 角色权限关系do对象集合
     */

    List<RolePriorityRelationshipDo> listByRoleId(@Param("roleId") Long roleId);
}
