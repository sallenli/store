package com.store.membership.service;

/**
 * 会员中心对外暴露接口
 */
public interface MembershipFacadeService {
    /**
     * 通知会员中心,用户当天第一次登陆
     * @param userAccount
     * @return
     */
    Boolean informFirstLoginDailyEvent(Long userAccount);

    /**
     * 通知会员中心，支付订单
     * @param userAccountId 用户账号id
     * @param totalOrderAmount 订单金额
     * @return
     */
    Boolean informPayOrderEvent(Long userAccountId,Long totalOrderAmount);

    /**
     * 通知用户中心，退货事件
     * @param userAccountId
     * @param totalOrderAmount
     * @return
     */
    Boolean informFinishReturnGoodsEvent(Long userAccountId,Long totalOrderAmount);

    /**
     * 通知会员中心，用户发表评论
     * @param userAccountId
     * @param showPictures 是否晒图
     * @return
     */
    Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures);

    /**
     * 通知会员中心，用户删除评论
     * @param userAccountId
     * @param showPictures
     * @return
     */
    Boolean informRemoveCommentEvent(Long userAccountId,Boolean showPictures);
}
