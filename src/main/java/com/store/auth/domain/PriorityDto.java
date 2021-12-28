package com.store.auth.domain;

import com.store.common.utils.BeanCopierUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Objects;

/**
 * 权限dto类
 */

public class PriorityDto {

    private final Logger log= LoggerFactory.getLogger(PriorityDto.class);

    private  Long id;
    //编号
    private String code;
    //权限url
    private String url;
    //权限备注
    private String priorityComment;
    //权限类型
    private Integer priorityType;
    //父权限类型
    private Long parentId;
    //权限创建时间
    private Date gmtCreate;
    //权限修改时间
    private Date gmtModified;

    public Logger getLog() {
        return log;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPriorityComment() {
        return priorityComment;
    }

    public void setPriorityComment(String priorityComment) {
        this.priorityComment = priorityComment;
    }

    public Integer getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(Integer priorityType) {
        this.priorityType = priorityType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityDto that = (PriorityDto) o;
        return Objects.equals(log, that.log) && Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(url, that.url) && Objects.equals(priorityComment, that.priorityComment) && Objects.equals(priorityType, that.priorityType) && Objects.equals(parentId, that.parentId) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(log, id, code, url, priorityComment, priorityType, parentId, gmtCreate, gmtModified);
    }

    /**
     * 数据拷贝
     */
    public <T> T clone(Class<T> clz){
        T target=null;
        try {
            target=clz.newInstance();
        } catch (Exception e) {
            log.error("Priority.clone",e);
        }
        BeanCopierUtils.copyProperties(this,target);
            return target;
    }
}
