package com.store.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 账号角色关系管理模块mapper
 */
@Mapper
public interface AccountRoleRelationShipMapper {

    /**
     * 根据角色id查询记录数
     * @return
     */
    @Select("select count(*) " +
            "from auth_account_role_relationship" +
            "where role_id = #{roleId}")
    Long countByRoleId(@Param("roleId") Long roleId);
}
