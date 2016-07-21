package com.mav.dao.impl;

import com.mav.dao.PurchaseDAO;
import com.mav.entity.Purchase;
import com.mav.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
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
    private HibernateUtil hibernateUtil;

    @Override
    public long savePurchase(Purchase purchase) {
        return (Long) hibernateUtil.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        return hibernateUtil.update(purchase);
    }

    @Override
    public void deletePurchase(long id) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        hibernateUtil.delete(purchase);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return hibernateUtil.fetchAll(Purchase.class);
    }

    @Override
    public Purchase getPurchase(long id) {
        return hibernateUtil.fetchById(id, Purchase.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Purchase> getAllPurchase(String purchaseId) {
        String query = "SELECT e.* FROM purchase e WHERE e.id like '%"+ purchaseId +"%'";
        List<Object[]> purcheseObjects = hibernateUtil.fetchAll(query);
        List<Purchase> purchases = new ArrayList<>();
        for(Object[] purcheseObject: purcheseObjects){
            Purchase purchase = new Purchase();
            long id = ((BigInteger) purcheseObject[0]).longValue();
            int user_id = (int) purcheseObject[1];
            int goods_id = (int) purcheseObject[2];
            Date date = (Date) purcheseObject[3];
            double price = (double) purcheseObject[4];
            int quantity = (int) purcheseObject[5];
            purchase.setId(id);
            purchase.setUserId(user_id);
            purchase.setGoodsId(goods_id);
            purchase.setDate(date);
            purchase.setPrice(price);
            purchase.setQuantity(quantity);
            purchases.add(purchase);
        }
        System.out.println(purchases);
        return purchases;
    }
}
