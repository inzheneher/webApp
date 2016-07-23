package com.mav.dao;

import com.mav.entity.Goods;

import java.util.List;

public interface GoodsDAO {
    long saveGoods(Goods goods);
    void deleteGoods(long id);
    List<Goods> getAllGoods();
    Goods getGoods(long id);
}
