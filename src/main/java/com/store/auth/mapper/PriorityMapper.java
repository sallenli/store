package com.store.auth.mapper;

import com.store.auth.domain.PriorityDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 权限管理模块mqpper
 */
@Mapper
public interface PriorityMapper {
    /**
     * 查询根权限列表
     */
    @Select("select "
                +"id,"
                +"code,"
                +"url,"
                +"priority_comment,"
                +"priority_type,"
                +"parent_id,"
                +"gmt_create,"
                +"gmt_modified "
                +"from auth_priority "
                +"where parent_id is null")
    @Results({
            @Result(column = "id", property="id",id=true),
            @Result(column = "code",property="code"),
            @Result( column = "url",property="url"),
            @Result(column = "priority_comment", property ="priorityComment"),
            @Result(column = "priority_type", property ="priorityType"),
            @Result(column = "parent_id", property ="parentId"),
            @Result(column = "gmt_create", property ="gmtCreate"),
            @Result(column = "gmt_modified", property ="gmtModified")})
    List<PriorityDo> listRootPriorities();

    /**
     * 根据父权限，查询子权限
     * @param parentId 父权限ID
     * @return 子权限ID
     */
    @Select("select "
            +"id,"
            +"code,"
            +"url,"
            +"priority_comment,"
            +"priority_type,"
            +"parent_id,"
            +"gmt_create,"
            +"gmt_modified "
            +"from auth_priority "
            +"where parent_id = #{parentId}")
    @Results({
            @Result(column = "id", property="id",id=true),
            @Result(column = "code",property="code"),
            @Result( column = "url",property="url"),
            @Result(column = "priority_comment", property ="priorityComment"),
            @Result(column = "priority_type", property ="priorityType"),
            @Result(column = "parent_id", property ="parentId"),
            @Result(column = "gmt_create", property ="gmtCreate"),
            @Result(column = "gmt_modified", property ="gmtModified")})
    List<PriorityDo>  listChildPriorities(@Param("parentId") Long parentId);

    /**
     * 新增权限
     * @param priorityDo 权限do对象
     */
    @Insert("insert into " +
            "auth_priority " +
            "(" +
            "code," +
            "url," +
            "priority_comment," +
            "priority_type," +
            "parent_id," +
            "gmt_create," +
            "gmt_modified) " +
            "values (" +
            "#{code}," +
            "#{url}," +
            "#{priorityComment}," +
            "#{priorityType}," +
            "#{parentId}," +
            "#{gmtCreate}," +
            "#{gmtModified})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Long savePriority(PriorityDo priorityDo);

    /**
     * 根据id查询
     * @param id 权限id
     * @return 返回权限
     */
    @Select("select "
            +"id,"
            +"code,"
            +"url,"
            +"priority_comment,"
            +"priority_type,"
            +"parent_id,"
            +"gmt_create,"
            +"gmt_modified "
            +"from auth_priority "
            +"where id = #{id}")
    @Results({
            @Result(column = "id", property="id",id=true),
            @Result(column = "code",property="code"),
            @Result( column = "url",property="url"),
            @Result(column = "priority_comment", property ="priorityComment"),
            @Result(column = "priority_type", property ="priorityType"),
            @Result(column = "parent_id", property ="parentId"),
            @Result(column = "gmt_create", property ="gmtCreate"),
            @Result(column = "gmt_modified", property ="gmtModified")})
    PriorityDo getPriorityById(@Param("id") Long id);

    /**
     * 更新权限
     * @param priorityDo 权限do对象
     *
     * @return
     */
    @Update("update auth_priority " +
            "set " +
                "code = #{code}," +
                "url = #{url}," +
                "priority_comment = #{priorityComment}," +
                "priority_type = #{priorityType}," +
                "parent_id = #{parentId}," +
                "gmt_modified = #{gmtModified} " +
            "where " +
                "id = #{id}"
    )
    Boolean updatePriority(PriorityDo priorityDo);


    /**
     * 删除权限
     * @param id 权限id
     */
    @Delete( "delete from auth_priority where id = #{id}")
    void removePriority(@Param("id")Long id);
}
