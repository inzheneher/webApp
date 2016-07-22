package com.mav.dao.impl;

import com.mav.dao.PurchaseDAO;
import com.mav.entity.Purchase;
import com.mav.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO{

    public PurchaseDAOImpl() {
        System.out.println("PurchaseDAOImpl");
    }

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public long savePurchase(Purchase purchase) {
        return (Long) hibernateTemplate.save(purchase);
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        hibernateTemplate.update(purchase);
    }

    @Override
    public void deletePurchase(long id) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        hibernateTemplate.delete(purchase);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return hibernateTemplate.loadAll(Purchase.class);
    }

    @Override
    public Purchase getPurchase(long id) {
        return hibernateTemplate.get(Purchase.class, id);
    }
}
