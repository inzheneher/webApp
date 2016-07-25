package com.mav.dao.impl;

import com.mav.dao.PurchaseDAO;
import com.mav.entity.Purchase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/context/componentScan.xml", "classpath:/context/persistance.xml"})
@Transactional
public class PurchaseDAOTest {
    @Autowired
    private PurchaseDAO dao;

    @Test
    public void findById() {
        Purchase purchase = dao.getPurchase(1);
        Assert.assertEquals(1, purchase.getId());
        Assert.assertEquals(1, purchase.getUserId());
        Assert.assertEquals(1, purchase.getGoodsId());
        Assert.assertEquals("2016-07-21", String.valueOf(purchase.getDate()));
        Assert.assertEquals(345.0, purchase.getPrice(), 0.001);
        Assert.assertEquals(1, purchase.getQuantity());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(1, dao.getAllPurchase().size());
    }

    @Test
    public void delete() {
        dao.deletePurchase(1);
        Assert.assertEquals(0, dao.getAllPurchase().size());
    }

    @Test
    public void updateGoods() {
        Purchase goods = dao.getPurchase(1);
        dao.updatePurchase(goods);
        Assert.assertEquals(goods, dao.getPurchase(1));
    }

    @Test
    public void saveGoods() {
        Purchase goods = dao.getPurchase(1);
        dao.savePurchase(goods);
        Assert.assertEquals(goods, dao.getPurchase(1));
    }
}
