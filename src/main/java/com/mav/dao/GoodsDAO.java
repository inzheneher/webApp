package com.mav.dao;

import java.util.List;

import com.mav.entity.Goods;

public interface GoodsDAO {
    long saveGoods(Goods goods);
    Goods updateGoods(Goods goods);
    void deleteGoods(long id);
    List<Goods> getAllGoods();
    Goods getGoods(long id);
    List<Goods> getAllGoods(String goodsName);
}
