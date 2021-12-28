package com.store.auth.service.impl;

import com.store.auth.dao.RoleDao;
import com.store.auth.dao.RolePriorityRelationshipDao;
import com.store.auth.dao.impl.AccountRoleRelationshipDao;
import com.store.auth.domain.*;
import com.store.auth.service.RoleService;
import com.store.common.utils.ObjectUtils;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private static  final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    /**
     * 角色管理模块dao
     */
    @Autowired
   private RoleDao roleDao;
    /**
     * 角色权限关系管理模块dao
     */
    @Autowired
    private RolePriorityRelationshipDao rolePriorityRelationshipDao;
    /**
     * 账号角色关系管理模块dao
     */
    @Autowired
    private AccountRoleRelationshipDao accountRoleRelationshipDao;

    @Override
    public List<RoleDto> listByPage(RoleQuery roleQuery) {
        try {

            List<RoleDo> roleDos = roleDao.listByPage(roleQuery);
            return ObjectUtils.convertList(roleDos,RoleDto.class);
        } catch (Exception e) {
            logger.error("RoleServiceImpl.listByPage",e.getMessage());
            return null;
        }

    }

    @Override
    public RoleDto getById(Long id) {
        try {
            RoleDo roleDo = roleDao.getById(id);
            if(roleDo == null){
                return null;
            }
            RoleDto resultDo = roleDo.clone(RoleDto.class);
            List<RolePriorityRelationshipDo> rolePriorityRelationshipDos = rolePriorityRelationshipDao.listByRoleId(id);
            resultDo.setRolePriorityRelationshipDtoList(ObjectUtils.convertList(rolePriorityRelationshipDos, RolePriorityRelationshipDto.class));
            return  resultDo;
        } catch (Exception e) {
            logger.error("RoleServiceImpl.getById",e.getMessage());
            return null;
        }

    }

    @Override
    public Boolean save(RoleDto roleDto) {
        try {
           roleDao.save(roleDto.clone(RoleDo.class));
            roleDto.getRolePriorityRelationshipDtoList().forEach((RolePriorityRelationshipDto relation)->{
                try {
                    rolePriorityRelationshipDao.saveRolePriorityRelationship(relation.clone(RolePriorityRelationshipDo.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return true;
        } catch (Exception e) {
            logger.error("RoleServiceImpl.save",e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean update(RoleDto roleDto) {
        try {
         return  roleDao.update(roleDto.clone(RoleDo.class));
        } catch (Exception e) {
            logger.error("RoleServiceImpl.update",e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean remove(Long id) {
        try {
            Long count = accountRoleRelationshipDao.countByRoleId(id);
            if(count > 0L){
                return false;
            }
            roleDao.remove(id);
            return  true;
        } catch (Exception e) {
            logger.error("RoleServiceImpl.remove",e.getMessage());
            return false;
        }


    }
}
