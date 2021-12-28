package com.store.auth.domain;



import com.store.common.utils.AbstractObject;

import java.util.Date;
import java.util.Objects;

/**
 * 角色和权限关联关系do类
 */

public class RolePriorityRelationshipDo  extends AbstractObject {
    //主键id
    private Long id;
    //角色Id
    private Long roleId;
    //权限id
    private Long priorityId;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePriorityRelationshipDo that = (RolePriorityRelationshipDo) o;
        return Objects.equals(id, that.id) && Objects.equals(roleId, that.roleId) && Objects.equals(priorityId, that.priorityId) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, priorityId, gmtCreate, gmtModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
