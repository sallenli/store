package com.store.auth.mapper;

import com.store.auth.domain.AccountPriorityRelationshipDo;
import org.apache.ibatis.annotations.*;

/**
 * *账号和权限之间关系管理 mapper
 */
@Mapper
public interface AccountPriorityRelationshipMapper {
    /**
     * 根据ID查询关联的账号数量
     * @param priorityId 权限ID
     * @return 账号数量
     */
    @Select("select count(1) " +
            "from auth_account_priority_relationship " +
            "where " +
            "priority_id = #{priorityId}")
    Long CountByPriorityId(@Param("priorityId")Long priorityId );

    /**
     * 插入账号和权限之间关系
     * @param accountPriorityRelationshipDo
     */
    @Insert("insert into " +
        "auth_account_priority_relationship " +
        "(account_id," +
        "priority_id," +
        "gmt_create," +
        "gmt_modified) " +
        "values(" +
        "#{accountId}," +
        "#{priorityId}," +
        "#{gmtCreate}," +
        "#{gmtModified})")
@Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void saveAccountPriorityRelationship(AccountPriorityRelationshipDo accountPriorityRelationshipDo);



}
