package com.store.auth.domain;

import com.store.common.utils.BeanCopierUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Objects;

/**
 * 权限Vo类
 */

public class PriorityVo {
    private static final Logger logger= LoggerFactory.getLogger(PriorityVo.class);
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
    private String gmtCreate;
    //权限修改时间
    private String gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityVo that = (PriorityVo) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(url, that.url) && Objects.equals(priorityComment, that.priorityComment) && Objects.equals(priorityType, that.priorityType) && Objects.equals(parentId, that.parentId) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, url, priorityComment, priorityType, parentId, gmtCreate, gmtModified);
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

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 数据拷贝方法
     * @param clz
     * @param <T>
     * @return
     */
    public <T> T clone(Class<T> clz){
        T target = null;
        try {
            target= clz.newInstance();
            BeanCopierUtils.copyProperties(this,target);
            return target;
        } catch (Exception e) {
            logger.error("CommentInfoDo.clone",e.getMessage());
            return null;
        }


    }
}
