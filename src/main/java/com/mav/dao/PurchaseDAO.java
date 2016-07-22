package com.mav.dao;

import java.util.List;

import com.mav.entity.Purchase;

public interface PurchaseDAO {
    long savePurchase(Purchase purchase);
    void updatePurchase(Purchase purchase);
    void deletePurchase(long id);
    List<Purchase> getAllPurchase();
    Purchase getPurchase(long id);
}
