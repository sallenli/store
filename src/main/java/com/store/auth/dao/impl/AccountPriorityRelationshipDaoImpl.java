package com.store.auth.dao.impl;

import com.store.auth.dao.AccountPriorityRelationshipDao;
import com.store.auth.domain.AccountPriorityRelationshipDo;
import com.store.auth.mapper.AccountPriorityRelationshipMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountPriorityRelationshipDaoImpl implements AccountPriorityRelationshipDao {

    private  static final Logger logger = LoggerFactory.getLogger(AccountPriorityRelationshipDaoImpl.class);
    @Autowired
    private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;
    /**
     * 根据ID查询关联的账号数量
     * @param priorityId 权限ID
     * @return 账号数量
     */
    @Override
    public Long countByPriorityId(Long priorityId) {
        try {
            return  accountPriorityRelationshipMapper.CountByPriorityId(priorityId);
        } catch (Exception e) {
            logger.error("AccountPriorityRelationshipDaoImpl.CountByPriorityId",e.getMessage());
            return null;
        }

    }

    @Override
    public Boolean saveAccountPriorityRelationship(AccountPriorityRelationshipDo accountPriorityRelationshipDo) {
        try {
            accountPriorityRelationshipMapper.saveAccountPriorityRelationship(accountPriorityRelationshipDo);
            return true;
        } catch (Exception e) {
            logger.error("AccountPriorityRelationshipDaoImpl.saveAccountPriorityRelationship",e.getMessage());
            return false;
        }

    }
}
