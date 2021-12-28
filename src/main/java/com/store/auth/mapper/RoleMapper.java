package com.store.auth.mapper;

import com.store.auth.domain.RoleDo;
import com.store.auth.domain.RoleQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 角色管理模块mapper组件
 */
@Mapper
public interface RoleMapper {
    /**
     * 分页查询角色
     * @param roleQuery 查询条件
     * @return 角色DO集合
     */
    @Select("<script>"+
            "select " +
            "a.id," +
            "a.code," +
            "a.remark," +
            "a.gmt_create," +
            "a.gmt_modified" +
            " from auth_role a," +
            " （select id from auth_role " +
            "where 1 = 1"+
            "<if test = 'code' and code != ''>" +
            "and code like '${code}%' " +
            "</if>"+
            "<if test  = 'name' and name != ''>"+
            "and name like '${name}%' "+
             "</if>"+
            "limit #{offset},#{size}"+
            ")b"+
            "where a.id = b.id"+
            "</script>"
    )
    @Results({@Result(column = "id" ,property = "id", id = true),
             @Result(column = "code",property = "code"),
            @Result(column = "remark",property = "remark"),
            @Result(column = "gmt_create",property = "gmtCreate"),
            @Result(column = "gmt_modified",property = "gmtModified")}
    )
    List<RoleDo> listByPage(RoleQuery roleQuery);

    /**
     * 根据id查询角色do对象
     * @param id
     * @return
     */
    @Select("select " +
            "id," +
            "code," +
            "remark," +
            "gmt_create," +
            "gmt_modified" +
            " from auth_role" +
            " where id = #{id}")
    @Results({@Result(column = "id" ,property = "id", id = true),
            @Result(column = "code",property = "code"),
            @Result(column = "remark",property = "remark"),
            @Result(column = "gmt_create",property = "gmtCreate"),
            @Result(column = "gmt_modified",property = "gmtModified")}
    )
    RoleDo getById(@Param("id")Long id);

    /**
     * 添加角色
     * @param roleDo 角色do
     */
    @Insert("insert into auth_role (" +
            "code," +
            "name," +
            "remark," +
            "gmt_create," +
            "gmt_modified) " +
            "values(" +
            "#{code}," +
            "#{name}," +
            "#{remark}," +
            "#{gmtCreate}," +
            "#{gmtModified})")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void save(RoleDo roleDo);

    /**
     * 更新角色
     * @param roleDo
     */
    @Update("update auth_role set" +
            "code = #{code}," +
            "name = #{name}," +
            "remark = #{remark}," +
            "gmt_modified = #{gmtModified}" +
            "where id = #{id}")
    void update(RoleDo roleDo);

    /**
     * 删除角色
     * @param id
     */
    @Delete("delete from auth_role where id = #{id}")
    void  remove(@Param("id")Long id);
}
