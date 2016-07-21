package com.mav.dao.impl;

import com.mav.dao.GoodsDAO;
import com.mav.entity.Goods;
import com.mav.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsDAOImpl implements GoodsDAO{

    public GoodsDAOImpl() {
        System.out.println("GoodsDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long saveGoods(Goods goods) {
        return (Long) hibernateUtil.save(goods);
    }

    @Override
    public Goods updateGoods(Goods goods) {
        return hibernateUtil.update(goods);
    }

    @Override
    public void deleteGoods(long id) {
        Goods goods = new Goods();
        goods.setId(id);
        hibernateUtil.delete(goods);
    }

    @Override
    public List<Goods> getAllGoods() {
        return hibernateUtil.fetchAll(Goods.class);
    }

    @Override
    public Goods getGoods(long id) {
        return hibernateUtil.fetchById(id, Goods.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Goods> getAllGoods(String goodsName) {
        String query = "SELECT e.* FROM goods e WHERE e.name like '%"+ goodsName +"%'";
        List<Object[]> goodsObjects = hibernateUtil.fetchAll(query);
        List<Goods> goodss = new ArrayList<>();
        for(Object[] goodsObject: goodsObjects) {
            Goods goods = new Goods();
            long id = ((BigInteger) goodsObject[0]).longValue();
            String name = (String) goodsObject[1];
            String description = (String) goodsObject[2];
            double price = (double) goodsObject[3];
            int quantity = (int) goodsObject[4];
            goods.setId(id);
            goods.setName(name);
            goods.setDescription(description);
            goods.setPrice(price);
            goods.setQuantity(quantity);
            goodss.add(goods);
        }
        System.out.println(goodss);
        return goodss;
    }
}
