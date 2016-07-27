package com.mav.user;

import com.mav.entity.Goods;

import java.util.List;

public interface GoodsService {
    long createGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(long id);

    List<Goods> getAllGoods();

    List<Goods> getAllGoods(String goodsName);

    Goods getGoods(long id);
}
