package com.store.auth.dao.impl;

import com.store.auth.dao.PriorityDAO;
import com.store.auth.domain.PriorityDo;
import com.store.auth.mapper.PriorityMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限管理模块dao impl
 */
@Repository
public class PriorityDAOImpl implements PriorityDAO {

    private static final Logger log = LoggerFactory.getLogger(PriorityDAOImpl.class);
    @Autowired
    private PriorityMapper priorityMapper;

    /**
     * 根权限查询
     * @return
     */
    @Override
    public List<PriorityDo> listRootPriorities() {

        try {
            return priorityMapper.listRootPriorities();
        } catch (Exception e) {
            log.error("PriorityDAOImpl.listRootPriorities",e.getMessage());
        }
        return  null;
    }

    /**
     * 根据父权限，查询子权限
     * @param parentId 父权限ID
     * @return 子权限ID
     */
    @Override
    public List<PriorityDo> listChildPriorities(Long parentId) {
        return priorityMapper.listChildPriorities(parentId);
    }
    /**
     * 新增权限
     * @param priorityDo 权限do对象
     * @return 返回插入id
     */
    @Override
    public Long savePriority(PriorityDo priorityDo) {

        try {
              priorityMapper.savePriority(priorityDo);
              return priorityDo.getId();
        } catch (Exception e) {
            log.error("PriorityDAOImpl.listChildPriorities",e.getMessage());

        }
        return  null;
    }
    /**
     * 根据id查询
     * @param id 权限id
     * @return 返回权限
     */
    @Override
    public PriorityDo getPriorityById(@Param("id") Long id) {
        try {
            return priorityMapper.getPriorityById(id);
        } catch (Exception e) {
            log.error("PriorityDAOImpl.getPriorityById",e.getMessage());
        }
        return  null;
    }
    /**
     * 更新权限
     * @param priorityDo 权限do对象
     *
     */
    @Override
    public Boolean updatePriority(PriorityDo priorityDo) {
        try {
            priorityMapper.updatePriority(priorityDo);
            return true;
        } catch (Exception e) {
            log.error("PriorityDAOImpl.updatePriority",e.getMessage());

        }
        return  false;
    }

    /**
     * 删除权限
     * @param id 权限id
     * @return
     */
    public Boolean removePriority(Long id){
        try {
            priorityMapper.removePriority(id);
            return true;
        } catch (Exception e) {
            log.error("PriorityDAOImpl.removePriority",e.getMessage());
            return  false;
        }
    }

}
