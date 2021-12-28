package com.store.membership.service;

import org.springframework.stereotype.Service;

@Service
public class MembershipFacadeServiceImpl implements MembershipFacadeService{
    @Override
    public Boolean informFirstLoginDailyEvent(Long userAccount) {
        return null;
    }

    @Override
    public Boolean informPayOrderEvent(Long userAccountId, Long totalOrderAmount) {
        return null;
    }

    @Override
    public Boolean informFinishReturnGoodsEvent(Long userAccountId, Long totalOrderAmount) {
        return null;
    }

    @Override
    public Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures) {
        return null;
    }

    @Override
    public Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures) {
        return null;
    }
}
