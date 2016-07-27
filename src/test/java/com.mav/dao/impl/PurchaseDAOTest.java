package com.mav.dao.impl;

import com.mav.dao.PurchaseDAO;
import com.mav.entity.Purchase;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

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
    public void saveGoods() {
        Purchase newPurchase = new Purchase();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.JULY, 25);

        newPurchase.setDate(calendar.getTime());
        newPurchase.setPrice(123.0);
        newPurchase.setQuantity(18);

        long newPurchaseId = dao.savePurchase(newPurchase);

        Purchase purchaseFromDb = dao.getPurchase(newPurchaseId);

        assertTrue(EqualsBuilder.reflectionEquals(newPurchase, purchaseFromDb));
    }
}
