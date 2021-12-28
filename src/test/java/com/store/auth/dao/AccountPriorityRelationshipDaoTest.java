package com.store.auth.dao;

import com.store.auth.domain.AccountPriorityRelationshipDo;
import com.store.common.utils.DateProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class AccountPriorityRelationshipDaoTest {

    @Autowired
    private DateProvider dateProvider;
    /**
     * 账号和权限管理模块dao
     */
    @Autowired
    private AccountPriorityRelationshipDao accountPriorityRelationshipDao;
    @Test
    public void countByPriorityId() throws Exception{
        Long priorityId = 1L;

        Long accountId = 1L;
       createAccountPriorityRelationshipDo(accountId, priorityId);

        Long accountId2= 2L;

         createAccountPriorityRelationshipDo(accountId2, priorityId);
        Long count = accountPriorityRelationshipDao.countByPriorityId(priorityId);
        Assert.assertEquals(2L,count.longValue());
    }

    @Test
    public void saveAccountPriorityRelationship() throws Exception{
            Long accountId = 1L;
            Long priorityId = 1L;
        AccountPriorityRelationshipDo accountPriorityRelationshipDo = createAccountPriorityRelationshipDo(accountId, priorityId);
        Assert.assertNotNull(accountPriorityRelationshipDo);
        Assert.assertThat(accountPriorityRelationshipDo.getId(),greaterThan(0L));
    }

    /**
     * 创建do对象
     * @return
     * @throws Exception
     */
    private AccountPriorityRelationshipDo createAccountPriorityRelationshipDo(Long accountId, Long priorityId ) throws Exception{
        AccountPriorityRelationshipDo accountPriorityRelationshipDo = new AccountPriorityRelationshipDo();
        accountPriorityRelationshipDo.setAccountId(accountId);
        accountPriorityRelationshipDo.setPriorityId(priorityId);
        accountPriorityRelationshipDo.setGmtCreate(dateProvider.getCurrentTime());
        accountPriorityRelationshipDo.setGmtModified(dateProvider.getCurrentTime());
        accountPriorityRelationshipDao.saveAccountPriorityRelationship(accountPriorityRelationshipDo);
        return accountPriorityRelationshipDo;
    }
}