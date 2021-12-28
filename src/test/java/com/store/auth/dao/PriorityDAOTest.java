package com.store.auth.dao;

import com.store.auth.constant.DefaultPriorityConstant;
import com.store.auth.domain.PriorityDo;
import com.store.common.utils.DateProvider;
import org.apache.ibatis.annotations.Result;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * 权限管理米快dao unit test
 */
@RunWith(SpringRunner.class)
@Transactional
@Rollback
@SpringBootTest
public class PriorityDAOTest {

    @Autowired
    private PriorityDAO priorityDAO;
    @Autowired
    private DateProvider dateProvider;
    @Test
    public void listRootPriorities() throws Exception {
        //构造2个根权限

        Long parentId = null;
        Map<Long, PriorityDo> priorityDoMap = createPriorityMap(parentId);
        //查询根权限集合
        List<PriorityDo> priorityDos = priorityDAO.listRootPriorities();
        Assert.assertThat(priorityDos.size(), greaterThan(0));
        Assert.assertEquals(priorityDoMap.size(),priorityDos.size());
        for (PriorityDo priorityDo: priorityDos) {
            PriorityDo targetPriority = priorityDoMap.get(priorityDo.getId());
            assertEquals(targetPriority,priorityDo);
        }

    }

    @Test
    public void listChildPriorities() throws  Exception{
        //构造数据

        Long parentId = 1L;
        Map<Long, PriorityDo> priorityDoMap = createPriorityMap(parentId);
        //查询根权限集合
        List<PriorityDo> priorityDos = priorityDAO.listChildPriorities(parentId);
        Assert.assertThat(priorityDos.size(), greaterThan(0));
        Assert.assertEquals(priorityDoMap.size(),priorityDos.size());
        for (PriorityDo priorityDo: priorityDos) {
            PriorityDo targetPriority = priorityDoMap.get(priorityDo.getId());
            assertEquals(targetPriority,priorityDo);
        }
    }

    @Test
    public void savePriority() throws Exception {
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(parentId);
        Long id = priorityDo.getId();
        Assert.assertNotNull(id);
        Assert.assertThat(id,greaterThan(0L));
    }

    @Test
    public void getPriorityById()  throws Exception{
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(parentId);
        PriorityDo result = priorityDAO.getPriorityById(priorityDo.getId());
        Assert.assertEquals(priorityDo,result);

    }

    @Test
    public void updatePriority() throws Exception{
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(parentId);
        priorityDo.setCode(priorityDo.getCode()+"update");
        priorityDo.setGmtModified(dateProvider.getCurrentTime());
        priorityDo.setPriorityComment(priorityDo.getPriorityComment()+"update");
        priorityDAO.updatePriority(priorityDo);
        PriorityDo result = priorityDAO.getPriorityById(priorityDo.getId());
        Assert.assertEquals(priorityDo,result);
    }

    @Test
    public void removePriority()  throws Exception{
        Long parentId = 1L;
        PriorityDo priorityDo = createPriorityDo(parentId);
        priorityDAO.removePriority(priorityDo.getId());
        PriorityDo result = priorityDAO.getPriorityById(priorityDo.getId());
        Assert.assertNull(result);
    }

    /**
     * 构造权限do对象
     * @return
     * @throws Exception
     */

    private PriorityDo createPriorityDo(Long parentId) throws Exception{
        Random random = new Random();
        int randomNum = random.nextInt();
        PriorityDo priorityDo = new PriorityDo();
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

    private Map<Long,PriorityDo> createPriorityMap(Long parentId) throws Exception{
        PriorityDo priorityDo1 = createPriorityDo(parentId);
        PriorityDo priorityDo2 = createPriorityDo(parentId);
        Long id1 = priorityDAO.savePriority(priorityDo1);
        Long id2 = priorityDAO.savePriority(priorityDo2);
        //查询根权限集合
        Map<Long,PriorityDo> priorityDoMap = new HashMap<Long,PriorityDo>();
        priorityDoMap.put(priorityDo1.getId(),priorityDo1);
        priorityDoMap.put(priorityDo2.getId(),priorityDo2);

        return priorityDoMap;
    }
}