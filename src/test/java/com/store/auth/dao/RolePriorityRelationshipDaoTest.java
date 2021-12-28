package com.store.auth.dao;

import com.store.auth.domain.AccountPriorityRelationshipDo;
import com.store.auth.domain.RolePriorityRelationshipDo;
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
public class RolePriorityRelationshipDaoTest {

    @Autowired
    private DateProvider dateProvider;
    /**
     * 账号和权限管理模块dao
     */
    @Autowired
    private RolePriorityRelationshipDao rolePriorityRelationshipDao;
    @Test
    public void countByPriorityId() throws Exception{
        Long priorityId = 1L;

        Long accountId = 1L;
        createRolePriorityRelationshipDo(accountId, priorityId);

        Long accountId2= 2L;

        createRolePriorityRelationshipDo(accountId2, priorityId);
        Long count = rolePriorityRelationshipDao.countByPriorityId(priorityId);
        Assert.assertEquals(2L,count.longValue());
    }

    @Test
    public void saveAccountPriorityRelationship() throws Exception{
        Long accountId = 1L;
        Long priorityId = 1L;
        RolePriorityRelationshipDo rolePriorityRelationshipDo = createRolePriorityRelationshipDo(accountId, priorityId);
        Assert.assertNotNull(rolePriorityRelationshipDo);
        Assert.assertThat(rolePriorityRelationshipDo.getId(),greaterThan(0L));
    }

    /**
     * 创建do对象
     * @return
     * @throws Exception
     */
    private RolePriorityRelationshipDo createRolePriorityRelationshipDo(Long roleId, Long priorityId ) throws Exception{
        RolePriorityRelationshipDo rolePriorityRelationshipDo = new RolePriorityRelationshipDo();
        rolePriorityRelationshipDo.setRoleId(roleId);
        rolePriorityRelationshipDo.setPriorityId(priorityId);
        rolePriorityRelationshipDo.setGmtCreate(dateProvider.getCurrentTime());
        rolePriorityRelationshipDo.setGmtModified(dateProvider.getCurrentTime());
        rolePriorityRelationshipDao.saveRolePriorityRelationship(rolePriorityRelationshipDo);
        return rolePriorityRelationshipDo;
    }
}