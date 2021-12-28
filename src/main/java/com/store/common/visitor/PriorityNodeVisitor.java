package com.store.common.visitor;

import com.store.auth.composite.PriorityNode;

/**
 * 权限节点数的访问者接口
 */

public interface PriorityNodeVisitor {
    /**
     *
     * @param priorityNode
     */
    void visit(PriorityNode priorityNode);
}
