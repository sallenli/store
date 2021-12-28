package com.store.auth.dao.impl;

import com.store.auth.dao.RolePriorityRelationshipDao;
import com.store.auth.domain.AccountPriorityRelationshipDo;
import com.store.auth.domain.RolePriorityRelationshipDo;
import com.store.auth.mapper.RolePriorityRelationshipMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色和权限关系管理Dao组件接口
 */
@Repository
public class RolePriorityRelationshipDaoImpl implements RolePriorityRelationshipDao {

    private static  final Logger logger = LoggerFactory.getLogger(RolePriorityRelationshipDaoImpl.class);
    @Autowired
    private RolePriorityRelationshipMapper  rolePriorityRelationshipMapper;

    @Override
    public Long countByPriorityId(Long priorityId) {
        return  rolePriorityRelationshipMapper.countByPriorityId(priorityId);

    }

    @Override
    public Boolean saveRolePriorityRelationship(RolePriorityRelationshipDo rolePriorityRelationshipDo) {
        try {
           rolePriorityRelationshipMapper.saveRolePriorityRelationship(rolePriorityRelationshipDo);
            return true;
        } catch (Exception e) {
            logger.error("AccountPriorityRelationshipDaoImpl.saveAccountPriorityRelationship",e.getMessage());
            return false;
        }
    }

    @Override
    public List<RolePriorityRelationshipDo> listByRoleId(Long roleId) {
        try {
            return rolePriorityRelationshipMapper.listByRoleId(roleId);
        } catch (Exception e) {
            logger.error("AccountPriorityRelationshipDaoImpl.listByRoleId",e.getMessage());
            return null;
        }
    }
}
