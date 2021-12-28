package com.store.auth.dao.impl;

import com.store.auth.dao.RoleDao;
import com.store.auth.domain.RoleDo;
import com.store.auth.domain.RoleQuery;
import com.store.auth.mapper.RoleMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限管理模块dao
 */
@Repository
public class RoleDaoImp implements RoleDao {

    private static final Logger logger = LoggerFactory.getLogger(RoleDaoImp.class);

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleDo> listByPage(RoleQuery roleQuery) {
        try {
            List<RoleDo> roleDos = roleMapper.listByPage(roleQuery);
            return roleDos;
        } catch (Exception e) {
            logger.error("RoleDaoImp.listByPage",e.getMessage());
            return null;
        }

    }

    @Override
    public RoleDo getById(Long id) {
        try {
            RoleDo roleDo = roleMapper.getById(id);
            return roleDo;
        } catch (Exception e) {
            logger.error("RoleDaoImp.getById",e.getMessage());
            return null;
        }

    }

    @Override
    public Boolean save(RoleDo roleDo) {
        try {
            roleMapper.save(roleDo);
            return true;
        } catch (Exception e) {
            logger.error("RoleDaoImp.getById",e.getMessage());
            return false;
        }

    }

    @Override
    public Boolean update(RoleDo roleDo) {
        try {
            roleMapper.update(roleDo);
            return true;
        } catch (Exception e) {
            logger.error("RoleDaoImp.update",e.getMessage());
            return false;
        }

    }

    @Override
    public Boolean remove(Long id) {
        try {
            roleMapper.remove(id);
            return true;
        } catch (Exception e) {
            logger.error("RoleDaoImp.remove",e.getMessage());
            return false;
        }
    }
}
