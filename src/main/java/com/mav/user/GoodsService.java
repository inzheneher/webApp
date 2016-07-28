package com.mav.user;

import com.mav.entity.Goods;

import java.util.List;

public interface GoodsService {
    long saveGoods(Goods goods);

    void deleteGoods(long id);

    List<Goods> getAllGoods();

    Goods getGoods(long id);
}
