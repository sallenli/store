package com.store.auth.domain;

/**
 * 角色查询条件
 */
public class RoleQuery {
    //分页查询起始位
    private  Integer offset;
    //每页记录数据
    private Integer size;
    //角色编号
    private String code;
    //角色名称
    private String name;
}
