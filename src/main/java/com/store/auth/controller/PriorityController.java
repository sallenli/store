package com.store.auth.controller;

import com.store.auth.domain.PriorityDto;
import com.store.auth.domain.PriorityVo;
import com.store.auth.service.PriorityService;
import com.store.common.utils.DateProvider;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块Controller
 */
@RestController
@RequestMapping("/auth/priority")
public class PriorityController {
    private static final Logger logger= LoggerFactory.getLogger(PriorityController.class);
    @Autowired
    PriorityService priorityService;
    @Autowired
    DateProvider dateProvider;

    /**
     * 查询根权限
     * @return
     */
    @GetMapping("/root")
    public List<PriorityVo> listRootPriorities() {

        try {
            List<PriorityDto> priorityDtoList = priorityService.listRootPriorities();
            if(priorityDtoList == null){
               priorityDtoList = new ArrayList<PriorityDto>();
            }
            List<PriorityVo> priorityVos = new ArrayList<>(priorityDtoList.size());
            for (PriorityDto dto : priorityDtoList) {
                priorityVos.add(convertPriorityDto2Vo(dto));

            }
            return priorityVos;
        } catch (Exception e) {
            logger.error("PriorityController.listRootPriorities", e.getMessage());
            return new ArrayList<PriorityVo>();
        }
    }
    @GetMapping("/child/{parentId}")
    public List<PriorityVo> listChildPriorities(@PathVariable("parentId") Long parentId){
        try {
            List<PriorityDto> priorityDtoList = priorityService.listChildPriorities(parentId);
            if(priorityDtoList == null){
                priorityDtoList = new ArrayList<PriorityDto>();
            }
            List<PriorityVo> priorityVos=new ArrayList<>(priorityDtoList.size());
            for (PriorityDto dto: priorityDtoList) {
                priorityVos.add(convertPriorityDto2Vo(dto));

            }
            return priorityVos;
        } catch (Exception e) {
            logger.error("PriorityController.listChildPriorities", e.getMessage());

        }
        return  new ArrayList<PriorityVo>();
    }

    /**
     * 新增权限
     * @param priorityVo  权限vo
     * @return
     */
    @PostMapping("/post")
    public Long saveUser(@RequestBody PriorityVo priorityVo){
        try {
             return   priorityService.savePriority(convertPriorityVo2Dto(priorityVo));
        } catch (Exception e) {
            logger.error("PriorityController.saveUser", e.getMessage());
        }
        return  0L;
    }

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return
     */
    @GetMapping("/{id}")
    public PriorityVo getPriorityById(@PathVariable("id") Long id){
        try {
            PriorityDto prioritydto = priorityService.getPriorityById(id);
            if(prioritydto == null){
                prioritydto = new PriorityDto();
            }
            return convertPriorityDto2Vo(prioritydto);
        } catch (Exception e) {
            logger.error("PriorityController.getPriorityById", e.getMessage());
        }
        return  new PriorityVo();
    }

    /**
     * 更新权限
     * @param priorityVo  权限vo
     * @return
     */
    @PutMapping("/id")
    public Boolean updatePriority(@RequestBody  PriorityVo priorityVo){
        try {
            Boolean update = priorityService.updatePriority(convertPriorityVo2Dto(priorityVo));
            return  update;
        } catch (Exception e) {
            logger.error("PriorityController.updatePriority", e.getMessage());
        }
        return false;
    }
    /**
     * 删除权限
     * @param id  权限id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean deletePriority(@PathVariable("id") Long  id){
        try {
            Boolean removeResult = priorityService.removePriority(id);
            return  removeResult;
        } catch (Exception e) {
            logger.error("PriorityController.deletePriority", e.getMessage());
            return false;
        }

    }

    /**
     * 将权限dto对象转换成Vo对象
     * @param dto
     * @return
     * @throws Exception
     */
    private PriorityVo convertPriorityDto2Vo(PriorityDto dto) throws Exception{
        final PriorityVo priorityVo = dto.clone(PriorityVo.class);
       priorityVo.setGmtModified(dateProvider.formatDateTime(dto.getGmtCreate()));
        priorityVo.setGmtModified(dateProvider.formatDateTime(dto.getGmtModified()));

        return priorityVo;
    }

    /**
     * 将VO对象转换成DTO对象
     * @return
     * @throws Exception
     */
    private PriorityDto convertPriorityVo2Dto(PriorityVo priorityVo) throws Exception{
        PriorityDto priorityDto = priorityVo.clone(PriorityDto.class);
        if(priorityVo.getGmtCreate()!= null){
            priorityDto.setGmtCreate(dateProvider.parseDateTime(priorityVo.getGmtCreate()));
        }
        if(priorityVo.getGmtModified()!=null){
            priorityDto.setGmtModified(dateProvider.parseDateTime(priorityVo.getGmtModified()));
        }

        return priorityDto;
    }
}
