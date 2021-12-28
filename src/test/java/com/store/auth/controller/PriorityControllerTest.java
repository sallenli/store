package com.store.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.store.auth.constant.DefaultPriorityConstant;
import com.store.auth.domain.PriorityDo;
import com.store.auth.domain.PriorityDto;
import com.store.auth.domain.PriorityVo;
import com.store.auth.service.PriorityService;
import com.store.common.utils.DateProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.ResultMatcher.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(PriorityController.class)
public class PriorityControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PriorityService priorityService;
    @MockBean
    private DateProvider dateProvider;

    @Before
    public void  setUp() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        when(dateProvider.getCurrentTime()).thenReturn(currentTime);
        when(dateProvider.formatDateTime(currentTime)).thenReturn(simpleDateFormat.format(currentTime));
        when(dateProvider.parseDateTime(simpleDateFormat.format(currentTime))).thenReturn(currentTime);
    }
    @Test
    public void listRootPriorities() throws Exception {
        Long parentId = null;
        //mock dao
        List<PriorityDto> priorityDtos = createMockPriorityDtos(parentId);
        when(priorityService.listRootPriorities()).thenReturn(priorityDtos);
        List<PriorityVo> listPriorityVos = convertPriorityDto(priorityDtos);
        mockMvc.perform(get("/auth/priority/root")).andExpect((ResultMatcher) content().json(JSONArray.toJSONString(listPriorityVos)));



    }

    @Test
    public void listChildPriorities() {
    }

    @Test
    public void saveUser() throws Exception{
        Long id = 2L;
        Long parentId = 1L;
        PriorityDto priorityDto = createPriorityDto(id,parentId);
        PriorityVo priorityVo = convertPriorityDto2Vo(priorityDto);
        when(priorityService.savePriority(priorityDto)).thenReturn(10086L);

        mockMvc.perform(post("auth/priority/").contentType("application/json").content(JSONObject.toJSONString(priorityVo))).
                andExpect(content().string("true"));
    }

    @Test
    public void getPriorityById() throws Exception {
        Long id = 2L;
        Long parentId = 1L;
        PriorityDto priorityDto = createPriorityDto(id,parentId);
        PriorityVo priorityVo = convertPriorityDto2Vo(priorityDto);
        when(priorityService.getPriorityById(id)).thenReturn(priorityDto);

        mockMvc.perform(get("/auth/priority/{id}",id)).andExpect((ResultMatcher) content().json(JSONObject.toJSONString(priorityVo)));


    }

    @Test
    public void updatePriority() throws Exception{

        Long id = 2L;
        Long parentId = 1L;
        PriorityDto priorityDto = createPriorityDto(id,parentId);
        PriorityVo priorityVo = convertPriorityDto2Vo(priorityDto);
        when(priorityService.updatePriority(priorityDto)).thenReturn(true);

        mockMvc.perform(put("auth/priority/{id}",id).contentType("application/json").content(JSONObject.toJSONString(priorityVo))).
                andExpect(content().string("true"));
    }

    @Test
    public void deletePriority() throws Exception{
        Long id = 2L;


        when(priorityService.removePriority(id)).thenReturn(true);

        mockMvc.perform(delete("auth/priority/{id}",id)).
                andExpect(content().string("true"));
    }

    private PriorityVo convertPriorityDto2Vo(PriorityDto priorityDto) throws Exception {
        PriorityVo priorityVo = new PriorityVo();
        priorityVo.setCode(priorityDto.getCode());
        priorityVo.setGmtCreate(dateProvider.formatDateTime(priorityDto.getGmtCreate()));
        priorityVo.setId(priorityDto.getId());
        priorityVo.setParentId(priorityDto.getParentId());
        priorityVo.setPriorityComment(priorityDto.getPriorityComment());
        priorityVo.setPriorityType(priorityDto.getPriorityType());
        priorityVo.setGmtModified(dateProvider.formatDateTime(priorityDto.getGmtModified()));
        priorityVo.setUrl(priorityDto.getUrl());
        return  priorityVo;
    }

    private List<PriorityDto> createMockPriorityDtos(Long parentId) throws Exception{
        Long id1 = 1L;
        Long id2= 2l;

        //mock dao
        List<PriorityDto> priorityDtos = new ArrayList<PriorityDto>();
        priorityDtos.add(createPriorityDto(id1,parentId));
        priorityDtos.add(createPriorityDto(id2,parentId));
        return priorityDtos;
    }

    private PriorityDto createPriorityDto(Long id,Long parentId) throws Exception{
        Random random = new Random();
        int randomNum = random.nextInt();
        PriorityDto priorityDto = new PriorityDto();
        priorityDto.setId(id);
        priorityDto.setCode("Test"+randomNum);
        priorityDto.setGmtCreate(dateProvider.getCurrentTime());
        priorityDto.setGmtModified(dateProvider.getCurrentTime());
        priorityDto.setParentId(parentId);
        priorityDto.setPriorityComment("test"+randomNum);
        priorityDto.setPriorityType(DefaultPriorityConstant.MENU);
        priorityDto.setUrl(null);
        priorityService.savePriority(priorityDto);
        return priorityDto;
    }

    /**
     * 将权限dto集合转换为权限vo集合
     * @param priorityDtos
     * @return
     */
    private List<PriorityVo> convertPriorityDto(List<PriorityDto> priorityDtos) throws  Exception{
        ArrayList<PriorityVo> priorityVos = new ArrayList<PriorityVo>(priorityDtos.size());
        for(PriorityDto priorityDto : priorityDtos){
            priorityVos.add(convertPriorityDto2Vo(priorityDto));
        }
        return priorityVos ;
    }

}