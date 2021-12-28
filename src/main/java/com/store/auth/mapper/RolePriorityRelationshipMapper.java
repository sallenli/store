package com.store.auth.mapper;


import com.store.auth.domain.RolePriorityRelationshipDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *角色和权限之间关系管理 mapper
 */
@Mapper
public interface RolePriorityRelationshipMapper {
    /**
     * 根据ID查询关联的角色数量
     * @param priorityId 权限ID
     * @return 角色数量
     */
    @Select("select count(1) " +
            "from auth_role_priority_relationship " +
            "where " +
            "priority_id = #{priorityId}")
  Long countByPriorityId(@Param("priorityId")Long priorityId );

    @Insert("insert into " +
            "auth_role_priority_relationship " +
            "(role_id," +
            "priority_id," +
            "gmt_create," +
            "gmt_modified) " +
            "values(" +
            "#{roleId}," +
            "#{priorityId}," +
            "#{gmtCreate}," +
            "#{gmtModified})")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void saveRolePriorityRelationship(RolePriorityRelationshipDo rolePriorityRelationshipDo);

    /**
     * 根据角色id查询角色和权限关系
     * @param roleId
     * @return 角色权限关系do对象集合
     */
    @Select("select " +
            "id," +
            "prority_id," +
            "role_id," +
            "gmt_create," +
            "gmt_modified" +
            " from auth_role_priority_relationship " +
            "where role_id = #{roleId}")
    List<RolePriorityRelationshipDo> listByRoleId(@Param("roleId") Long roleId);
}
