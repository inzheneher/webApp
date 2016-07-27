package com.mav.dao.impl;

import com.mav.dao.GoodsDAO;
import com.mav.entity.Goods;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/context/componentScan.xml", "classpath:/context/persistance.xml"})
@Transactional
public class GoodsDAOTest {
    @Autowired
    private GoodsDAO dao;

    @Test
    public void findById() {
        Goods goods = dao.getGoods(1);
        Assert.assertEquals(1, goods.getId());
        Assert.assertEquals("tomat", goods.getName());
        Assert.assertEquals("vegetable in red", goods.getDescription());
        Assert.assertEquals(105.0, goods.getPrice(), 0.001);
        Assert.assertEquals(1, goods.getQuantity());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(1, dao.getAllGoods().size());
    }

    @Test
    public void delete() {
        dao.deleteGoods(1);
        Assert.assertEquals(0, dao.getAllGoods().size());
    }

    @Test
    public void saveGoods() {
        Goods newGoods = new Goods();
        newGoods.setName("new goody");
        newGoods.setPrice(123.0);
        newGoods.setDescription("dis is new fancy goody!");
        newGoods.setQuantity(100);

        long newGoodyId = dao.saveGoods(newGoods);

        Goods goodyFromDb = dao.getGoods(newGoodyId);

        assertTrue(EqualsBuilder.reflectionEquals(newGoods, goodyFromDb));
    }
}
