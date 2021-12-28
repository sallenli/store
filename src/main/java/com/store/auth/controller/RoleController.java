package com.store.auth.controller;



import com.store.auth.domain.*;
import com.store.auth.service.RoleService;
import com.store.common.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理模块controller 组件
 */
@RestController
@RequestMapping("/auth/priority")
public class RoleController {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询角色
     * @param query 查询条件
     * @return 角色VO集合
     */
    @GetMapping("/page")
    public List<RoleVo> ListByPage(RoleQuery query){
        List<RoleDto> roleDtos = roleService.listByPage(query);
        try {
            Map<Long,RoleDto> roleDtoMap = convertList2Map(roleDtos);
         return ObjectUtils.convertList(roleDtos, RoleVo.class);

        } catch (Exception e) {
            Logger.error("RoleController.ListByPage",e.getMessage());
            return new ArrayList<RoleVo>();
        }
    }

    /**
     * 根据id查询角色
     * @param id 角色id
     * @return
     */
    @GetMapping("/id")
    public RoleVo getById(@PathVariable("id") Long id){
        try {
            RoleDto role = roleService.getById(id);
            RoleVo resultRole = role.clone(RoleVo.class);
            List<RolePriorityRelationshipDto> relations = role.getRolePriorityRelationshipDtoList();
            resultRole.setRolePriorityRelationshipVoList(ObjectUtils.convertList(relations,RolePriorityRelationshipVo.class));
            return  resultRole;
        } catch (Exception e) {
            Logger.error("RoleController.getById",e.getMessage());
            return null;
        }
    }

    public Boolean save(RoleVo roleVo){

    }

    /**
     * 将角色list转换成map
     * @param roles 角色list
     * @return 角色map
     */
    private Map<Long,RoleDto> convertList2Map(List<RoleDto> roles){
        Map<Long,RoleDto>  roleMap = new HashMap<Long,RoleDto>();
          roles.forEach((RoleDto role)->{roleMap.put(role.getId(),role);});
        return roleMap;
    }
}
