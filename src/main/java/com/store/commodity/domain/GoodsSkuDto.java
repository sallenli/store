package com.store.commodity.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author  sallen
 * @beanInfo 商品sku dto
 *
 */
@Data
public class GoodsSkuDto {

    //id
    private Long id;
    //商品id
    private Long goodsId;
    //商品sku编号
    private  String goodsSkuCode;
    //商品采购价格
    private Double purchasePrice;
    //销售价格
    private Double salesPirce;
    private String saleProperties;
    //商品折扣
    private Double discount;
    //商品名称
    private String goodsName;
    //商品毛重
    private Double grossWeight;
    //商品长度
    private Double goodsLength;
    //商品宽度
    private Double goodsWidth;
    //商品高度
    private Double goodsHeight;
    //商品创建时间
    private Date gmtCreate;
    //商品修改时间
    private Date gmtModified;



}
