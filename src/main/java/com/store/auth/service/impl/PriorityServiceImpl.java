package com.store.auth.service.impl;

import com.store.common.utils.DateProvider;
import com.store.common.visitor.PriorityNodeRelatedCheckVisitor;
import com.store.common.visitor.PriorityNodeRemoveVisitor;
import com.store.common.visitor.PriorityNodeVisitor;
import com.store.auth.composite.PriorityNode;
import com.store.auth.dao.AccountPriorityRelationshipDao;
import com.store.auth.dao.PriorityDAO;

import com.store.auth.dao.RolePriorityRelationshipDao;
import com.store.auth.domain.PriorityDo;
import com.store.auth.domain.PriorityDto;
import com.store.auth.service.PriorityService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {
    private static final Logger logger =  LoggerFactory.getLogger(PriorityServiceImpl.class);
    @Autowired
    private PriorityDAO priorityDAO;

    @Autowired
    private RolePriorityRelationshipDao rolePriorityRelationshipDao;

    @Autowired
    private AccountPriorityRelationshipDao accountPriorityRelationshipDao;
    @Autowired
    DateProvider dateProvider;
    @Override
    public List<PriorityDto> listRootPriorities() {

        try {
            List<PriorityDo> priorityDos = priorityDAO.listRootPriorities();
            if(priorityDos == null){
                return  null;
            }
            List<PriorityDto> priorityDtoList= new ArrayList<>(priorityDos.size());
            for (PriorityDo prioritydo: priorityDos) {
                PriorityDto dto = prioritydo.clone(PriorityDto.class);
                priorityDtoList.add(dto);
            }
            return  priorityDtoList;
        } catch (Exception e) {
            logger.error("PriorityServiceImpl.priorityServiceList",e.getMessage());
            return  null;
        }
    }

    @Override
    public List<PriorityDto> listChildPriorities(Long parentId) {

        try {
            List<PriorityDo> priorityDos = priorityDAO.listChildPriorities(parentId);
            if(priorityDos == null)
            {
                return null;
            }
            List<PriorityDto> priorityDtoList= new ArrayList<>(priorityDos.size());
            for (PriorityDo prioritydo: priorityDos) {
                PriorityDto dto = prioritydo.clone(PriorityDto.class);
                priorityDtoList.add(dto);
            }
            return  priorityDtoList;
        } catch (Exception e) {
            logger.error("PriorityServiceImpl.listChildPriorities",e.getMessage());
            return  null;
        }
    }

    @Override
    public Long savePriority(PriorityDto priorityDto) {


        try {
            return priorityDAO.savePriority(priorityDto.clone(PriorityDo.class));
        } catch (Exception e) {
            logger.error("PriorityServiceImpl.saveUser",e.getMessage());
            return null;
        }
    }

    @Override
    public PriorityDto getPriorityById(Long id) {

        try {
            PriorityDo priorityDo=priorityDAO.getPriorityById(id);
            if(priorityDo == null){
                return null;
            }
            return priorityDo.clone(PriorityDto.class);
        } catch (Exception e) {
            logger.error("PriorityServiceImpl.getPriorityById",e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean updatePriority(PriorityDto priorityDto) {
        try {
            priorityDto.setGmtModified(dateProvider.getCurrentTime());
            PriorityDo clone = priorityDto.clone(PriorityDo.class);

            return   priorityDAO.updatePriority(clone);

        } catch (Exception e) {
            logger.error("PriorityServiceImpl.updatePriority",e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean removePriority(Long id) {
        try {
            PriorityDo priorityDo = priorityDAO.getPriorityById(id);
            PriorityNode priorityNode = priorityDo.clone(PriorityNode.class);
            PriorityNodeRelatedCheckVisitor relatedCheckVisitor = new PriorityNodeRelatedCheckVisitor(priorityDAO,rolePriorityRelationshipDao,accountPriorityRelationshipDao);
            //访问节点权限
            relatedCheckVisitor.visit(priorityNode);
           Boolean relatedCheckResult = relatedCheckVisitor.getRelatedCheckResult();
           if(relatedCheckResult){
               return false;
           }
            PriorityNodeVisitor removeNodeVisitor = new PriorityNodeRemoveVisitor(priorityDAO);
           removeNodeVisitor.visit(priorityNode);
            return  true;
        } catch (Exception e) {
            logger.error("PriorityServiceImpl.removePriority",e.getMessage());
            return false;
        }
    }
}
