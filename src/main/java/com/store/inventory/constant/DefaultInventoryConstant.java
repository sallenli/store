package com.store.inventory.constant;

/**
 * 库存状态常量类
 */
public class DefaultInventoryConstant {
    private DefaultInventoryConstant(){

    }
    /**
     * 库存状态判断（有库存，没有库存）
     */
    public  static final Integer IN_STOCK = 1;

    public  static final Integer NOT_IN_STOCK = 0;

    /**
     * 商品库存更新操作
     */
    //提交订单
    public static final Integer SUBMIT_ORDER = 1;
    //支付订单
    public static final Integer PAY_ORDER = 2;
    //取消订单
    public static final Integer Cancel_ORDER = 3;

}
