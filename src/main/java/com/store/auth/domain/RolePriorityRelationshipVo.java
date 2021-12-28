package com.store.auth.domain;

import com.store.common.utils.AbstractObject;
import lombok.Data;

import java.util.Date;
@Data
public class RolePriorityRelationshipVo extends AbstractObject {
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
}
