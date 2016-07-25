package com.mav.dao.impl;

import com.mav.dao.PurchaseDAO;
import com.mav.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public PurchaseDAOImpl() {
        System.out.println("PurchaseDAOImpl");
    }

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
