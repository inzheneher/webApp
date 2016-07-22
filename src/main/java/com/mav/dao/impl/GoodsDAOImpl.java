package com.mav.dao.impl;

import com.mav.dao.GoodsDAO;
import com.mav.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDAOImpl implements GoodsDAO{

    public GoodsDAOImpl() {
        System.out.println("GoodsDAOImpl");
    }

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public long saveGoods(Goods goods) {
        return (Long) hibernateTemplate.save(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        hibernateTemplate.update(goods);
    }

    @Override
    public void deleteGoods(long id) {
        Goods goods = new Goods();
        goods.setId(id);
        hibernateTemplate.delete(goods);
    }

    @Override
    public List<Goods> getAllGoods() {
        return hibernateTemplate.loadAll(Goods.class);
    }

    @Override
    public Goods getGoods(long id) {
        return hibernateTemplate.get(Goods.class, id);
    }
}
