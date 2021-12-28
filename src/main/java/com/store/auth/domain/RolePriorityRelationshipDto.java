package com.store.auth.domain;



import com.store.common.utils.AbstractObject;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * 角色和权限关联关系do类
 */
@Data
public class RolePriorityRelationshipDto extends AbstractObject {
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
