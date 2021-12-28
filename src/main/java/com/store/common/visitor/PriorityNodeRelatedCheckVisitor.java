package com.store.common.visitor;

import com.store.auth.composite.PriorityNode;
import com.store.auth.dao.AccountPriorityRelationshipDao;
import com.store.auth.dao.PriorityDAO;
import com.store.auth.dao.RolePriorityRelationshipDao;
import com.store.auth.domain.PriorityDo;

import java.util.List;

/**
 * 检查权限树节点关联账户
 */
public class PriorityNodeRelatedCheckVisitor  implements PriorityNodeVisitor{

    /**
     * 关联检查结果
     * @param priorityNode
     */
    private Boolean relatedCheckResult = false;

    public Boolean getRelatedCheckResult() {
        return relatedCheckResult;
    }

    /**
     * 权限管理模块的DAO组件
     */
    private PriorityDAO priorityDAO;
    /**
     * 权限管理模块角色和权限管理Dao组件
     */
    private RolePriorityRelationshipDao rolePriorityRelationshipDao;
    /**
     * 权限管理模块账号和权限管理Dao组件
     */
    private AccountPriorityRelationshipDao accountPriorityRelationshipDao;

    /**
     * 构造函数
     */
    public PriorityNodeRelatedCheckVisitor(PriorityDAO priorityDAO,
                                           RolePriorityRelationshipDao rolePriorityRelationshipDao,
                                           AccountPriorityRelationshipDao accountPriorityRelationshipDao){

        this.priorityDAO=priorityDAO;
        this.rolePriorityRelationshipDao=rolePriorityRelationshipDao;
        this.accountPriorityRelationshipDao=accountPriorityRelationshipDao;
    }
    /**
     * 访问权限节点树
     * @param node 权限节点
     *
     */
    @Override
    public void visit(PriorityNode node) {
          List<PriorityDo> priorityDos= priorityDAO.listChildPriorities(node.getId());
        /**
         * 先检查本节点是否有账号/角色关联，有的话，直接结束方法。没有在进行子节点遍历
         */
        if(relatedCheck(node)){
            this.relatedCheckResult = true;
            return;
        }
        /**
         * 检查子节点关联
         */
        if(priorityDos!=null&&priorityDos.size()>0){
              for (PriorityDo priorityDo:priorityDos) {
                  PriorityNode priorityNode = priorityDo.clone(PriorityNode.class);
                  //访问者模式
                  priorityNode.accept(this);
              }
          }

    }

    /**
     * 检查当前节点是否被角色或者账号关联
     * @param node 权限节点
     * @return 是否被关联 true: 被关联 false ：没有关联
     */
    public Boolean relatedCheck(PriorityNode node){
        Long rolePriorityId = rolePriorityRelationshipDao.countByPriorityId(node.getId());
        if(rolePriorityId != null && rolePriorityId >0){
            return true;
        }
        Long accountPriorityId = accountPriorityRelationshipDao.countByPriorityId(node.getId());
        if(accountPriorityId != null && accountPriorityId > 0){
            return true;
        }
        return  false;
    }


}
