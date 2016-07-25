package com.mav.dao;

import com.mav.entity.Purchase;

import java.util.List;

public interface PurchaseDAO {
    long savePurchase(Purchase purchase);

    void updatePurchase(Purchase purchase);

    void deletePurchase(long id);

    List<Purchase> getAllPurchase();

    Purchase getPurchase(long id);
}
