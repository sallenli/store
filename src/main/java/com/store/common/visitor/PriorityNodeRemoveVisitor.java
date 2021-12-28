package com.store.common.visitor;

import com.store.auth.composite.PriorityNode;
import com.store.auth.dao.PriorityDAO;
import com.store.auth.domain.PriorityDo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 权限节点数的删除（访问者模式)
 */
public class PriorityNodeRemoveVisitor implements PriorityNodeVisitor{

    @Autowired
    PriorityDAO priorityDAO;

    public PriorityNodeRemoveVisitor(PriorityDAO priorityDAO){
        this.priorityDAO = priorityDAO;
    }

    /**
     * 访问权限树节点
     * @param node 权限节点
     */
    @Override
    public void visit(PriorityNode node) {
        List<PriorityDo> priorityDos = priorityDAO.listChildPriorities(node.getId());

      if( priorityDos != null && priorityDos.size() > 0){
          for (PriorityDo priorityDo:priorityDos) {
              PriorityNode priorityNode = priorityDo.clone(PriorityNode.class);
              priorityNode.accept(this);
          }
      }
        removePriority(node);
    }

    /**
     * 删除权限
     * @param priorityNode
     */
    public void removePriority(PriorityNode priorityNode){
        priorityDAO.removePriority(priorityNode.getId());
    }
}
