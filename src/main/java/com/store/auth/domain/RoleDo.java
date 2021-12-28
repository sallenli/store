package com.store.auth.domain;

import com.store.common.utils.AbstractObject;
import lombok.Data;

import java.util.Date;

/**
 * 角色Do类
 */
@Data
public class RoleDo  extends AbstractObject {

    private Long id;
    //'角色编号'
    private String code;
    //'角色名称'
    private String Name;
    //'角色的说明备注'
    private String remark;
    //角色是否启用：1 启用 0 未启用
   // private int enabled;

    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

}
