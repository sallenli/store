package com.store.auth.service;

import com.store.auth.constant.DefaultPriorityConstant;
import com.store.auth.dao.AccountPriorityRelationshipDao;
import com.store.auth.dao.PriorityDAO;
import com.store.auth.dao.RolePriorityRelationshipDao;
import com.store.auth.domain.PriorityDo;
import com.store.auth.domain.PriorityDto;
import com.store.common.utils.DateProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriorityServiceTest {

    @Autowired
    private PriorityService priorityService;

    @MockBean
    private PriorityDAO priorityDAO;

    @MockBean
    private RolePriorityRelationshipDao rolePriorityRelationshipDao;

    @MockBean
    private AccountPriorityRelationshipDao accountPriorityRelationshipDao;

    @Autowired
    private DateProvider dateProvider;
    @Test
    public void listRootPriorities() throws  Exception{
      


        Long parentId = null;
        //mock dao
        List<PriorityDo> priorityDos = createMockPriorityDos(parentId);
        when(priorityDAO.listRootPriorities()).thenReturn(priorityDos);

        Map<Long, PriorityDto> rootPriorityDtos = convertPriorityDto(priorityDos);
        List<PriorityDto> resultPriorityDtos = priorityService.listRootPriorities();

        Assert.assertEquals(rootPriorityDtos.size(),resultPriorityDtos.size());

        for(PriorityDto resultRootPriorityDto : resultPriorityDtos){
            PriorityDto rootPriorityDto = rootPriorityDtos.get(resultRootPriorityDto.getId());
            Assert.assertEquals(rootPriorityDto,resultRootPriorityDto);
        }
    }

    @Test
    public void listChildPriorities() throws Exception{

        Long parentId = 1L;
        List<PriorityDo> priorityDos = createMockPriorityDos(parentId);

        when(priorityDAO.listChildPriorities(parentId)).thenReturn(priorityDos);

        Map<Long, PriorityDto> childPriorityDtos = convertPriorityDto(priorityDos);

        List<PriorityDto> resultChildPriorities = priorityService.listChildPriorities(parentId);
        comparePriorityDos(childPriorityDtos,resultChildPriorities);
    }

    /**
     * ??????????????????
     */
    @Test
    public void savePriority() throws Exception {
        Long id = 2L;
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(id, parentId);
        PriorityDto priorityDto = priorityDo.clone(PriorityDto.class);

        when(priorityDAO.savePriority(priorityDo)).thenReturn(id);
        priorityService.savePriority(priorityDto);
        verify(priorityDAO,times(1)).savePriority(priorityDo);


    }

    /**
     * ??????id????????????
     * @throws Exception
     */
    @Test
    public void getPriorityById() throws Exception{
        Long id = 1L;
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(id, parentId);
        PriorityDto priorityDto = priorityDo.clone(PriorityDto.class);
        when(priorityDAO.getPriorityById(parentId)).thenReturn(priorityDo);
        PriorityDto resultPriority = priorityService.getPriorityById(id);

        Assert.assertEquals(priorityDto,resultPriority);

    }

    /**
     * ?????????????????? xxxxxxx
     */
    @Test
    public void updatePriority() throws Exception{
        Long id = 2L;
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(id, parentId);
        PriorityDto priorityDto = convertPriorityDo2Dto(priorityDo);



        when(priorityDAO.updatePriority(priorityDo)).thenReturn(true);

        priorityService.updatePriority(priorityDto);

        verify(priorityDAO,times(1)).updatePriority(priorityDo);
    }

    @Test
    public void removePriority() throws Exception {
        //mock??????dao??????
        Long id = 2L;
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(id, parentId);
        when(priorityDAO.getPriorityById(id)).thenReturn(priorityDo);

        Long childId = 3L;
        PriorityDo  childPriority = createPriorityDo(childId,id);
        List<PriorityDo> childPriorityDos = new ArrayList<PriorityDo>();
        childPriorityDos.add(childPriority);
        when(priorityDAO.listChildPriorities(id)).thenReturn(childPriorityDos);
        when(priorityDAO.listChildPriorities(childId)).thenReturn(new ArrayList<PriorityDo>());

        when(rolePriorityRelationshipDao.countByPriorityId(childId)).thenReturn(0L);
        when(accountPriorityRelationshipDao.countByPriorityId(childId)).thenReturn(0l);

        when(rolePriorityRelationshipDao.countByPriorityId(id)).thenReturn(0L);
        when(accountPriorityRelationshipDao.countByPriorityId(id)).thenReturn(0l);

        when(priorityDAO.removePriority(childId)).thenReturn(true);
        when(priorityDAO.removePriority(id)).thenReturn(true);

        //????????????service?????????
        Boolean result = priorityService.removePriority(id);
        //??????

        verify(priorityDAO,times(1)).getPriorityById(id);
        verify(priorityDAO,times(2)).listChildPriorities(id);
        verify(priorityDAO,times(2)).listChildPriorities(childId);
        verify(rolePriorityRelationshipDao,times(1)).countByPriorityId(id);
        verify(rolePriorityRelationshipDao,times(1)).countByPriorityId(childId);
        verify(accountPriorityRelationshipDao,times(1)).countByPriorityId(id);
        verify(accountPriorityRelationshipDao,times(1)).countByPriorityId(childId);
        verify(priorityDAO,times(1)).removePriority(id);
        verify(priorityDAO,times(1)).removePriority(childId);

        assertTrue(result);

    }

    private PriorityDo createPriorityDo(Long id,Long parentId) throws Exception{
        Random random = new Random();
        int randomNum = random.nextInt();
        PriorityDo priorityDo = new PriorityDo();
        priorityDo.setId(id);
        priorityDo.setCode("Test"+randomNum);
        priorityDo.setGmtCreate(dateProvider.getCurrentTime());
        priorityDo.setGmtModified(dateProvider.getCurrentTime());
        priorityDo.setParentId(parentId);
        priorityDo.setPriorityComment("test"+randomNum);
        priorityDo.setPriorityType(DefaultPriorityConstant.MENU);
        priorityDo.setUrl(null);
        priorityDAO.savePriority(priorityDo);
        return priorityDo;
    }

    private Map<Long,PriorityDo> createPriorityMap(Long id ,Long parentId) throws Exception{
        PriorityDo priorityDo1 = createPriorityDo(id,parentId);
        PriorityDo priorityDo2 = createPriorityDo(id,parentId);
        Long id1 = priorityDAO.savePriority(priorityDo1);
        Long id2 = priorityDAO.savePriority(priorityDo2);
        //?????????????????????
        Map<Long,PriorityDo> priorityDoMap = new HashMap<Long,PriorityDo>();
        priorityDoMap.put(priorityDo1.getId(),priorityDo1);
        priorityDoMap.put(priorityDo2.getId(),priorityDo2);

        return priorityDoMap;
    }

    /**
     * ?????????do?????????????????????dto??????
     * @param priorityDos
     * @return
     */
    private Map<Long,PriorityDto> convertPriorityDto(List<PriorityDo> priorityDos){
        Map<Long,PriorityDto> priorityDtos = new HashMap<Long,PriorityDto>(priorityDos.size());
        for(PriorityDo priorityDo : priorityDos){
            priorityDtos.put(priorityDo.getId(),priorityDo.clone(PriorityDto.class));
        }
        return priorityDtos;
    }

    /**
     * ?????????????????????do??????
     * @param parentId ?????????id
     * @return ??????do??????
     * @throws Exception
     */
    private List<PriorityDo> createMockPriorityDos(Long parentId) throws Exception{
        Long id1 = 1L;
        Long id2= 2l;
        
        //mock dao
        List<PriorityDo> priorityDos = new ArrayList<PriorityDo>();
        priorityDos.add(createPriorityDo(id1,parentId));
        priorityDos.add(createPriorityDo(id2,parentId));
        return priorityDos;
    }

    /**
     * ??????2?????????dto??????
     * @param priorityDtoMap ??????dto??????1
     * @param priorityDtos ??????dto??????2
     */
    public void comparePriorityDos(Map<Long,PriorityDto> priorityDtoMap,
                                   List<PriorityDto> priorityDtos){
        assertEquals(priorityDtoMap.size(),priorityDtos.size());
                for(PriorityDto resultPriorityDto: priorityDtos){
                    final PriorityDto rootPriorityDto = priorityDtoMap.get(resultPriorityDto.getId());
                    assertEquals(rootPriorityDto,resultPriorityDto);
                }
    }

    /**
     * ?????????do?????????????????????dto??????
     * @param priorityDo
     * @return
     */
    private  PriorityDto convertPriorityDo2Dto(PriorityDo priorityDo){
        PriorityDto priorityDto = new PriorityDto();
        priorityDto.setCode(priorityDo.getCode());
        priorityDto.setGmtCreate(priorityDo.getGmtCreate());
        priorityDto.setId(priorityDo.getId());
        priorityDto.setParentId(priorityDo.getParentId());
        priorityDto.setPriorityComment(priorityDo.getPriorityComment());
        priorityDto.setPriorityType(priorityDo.getPriorityType());
        priorityDto.setGmtModified(priorityDo.getGmtModified());
        priorityDto.setUrl(priorityDo.getUrl());
        return  priorityDto;
    }
}