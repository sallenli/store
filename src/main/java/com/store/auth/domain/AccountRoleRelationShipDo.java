package com.store.auth.domain;

import com.store.common.utils.AbstractObject;
import lombok.Data;

import java.util.Date;

/**
 * 账号角色关系do类
 */
@Data
public class AccountRoleRelationShipDo  extends AbstractObject {

    private Long id;
    //账号id
    private Long accountId;
    //角色id
    private Long roleId;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;
}
