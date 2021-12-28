package com.store.auth.dao.impl;

import com.store.auth.mapper.AccountRoleRelationShipMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRoleRelationshipDaoImpl implements AccountRoleRelationshipDao{

    private static final Logger logger = LoggerFactory.getLogger(AccountRoleRelationshipDaoImpl.class);

    @Autowired
    private AccountRoleRelationShipMapper accountRoleRelationShipMapper;

    @Override
    public Long countByRoleId(Long roleId) {
        try {
            return  accountRoleRelationShipMapper.countByRoleId(roleId);
        } catch (Exception e) {
            logger.error("AccountRoleRelationshipDaoImpl.countByRoleId",e.getMessage());
            return null;
        }

    }
}
