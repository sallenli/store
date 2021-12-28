package com.store.inventory.domain;

import lombok.Data;

import java.util.Date;

/**
 * 库存更新消息do
 */
@Data
public class StockUpdateMessageDo {

    private Long id;
    //库存更新消息id
    private String messageId;
    //库存更新操作
    private Integer operation;
    //参数对象:json格式
    private String parameter;
    //参数类型
    private String parameterClazz;
    private Date gmtCreate;
    private Date gmtModified;
}
