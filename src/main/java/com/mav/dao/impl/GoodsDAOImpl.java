package com.mav.dao.impl;

import com.mav.dao.GoodsDAO;
import com.mav.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDAOImpl implements GoodsDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public GoodsDAOImpl() {
        System.out.println("GoodsDAOImpl");
    }

    @Override
    public long saveGoods(Goods goods) {
        hibernateTemplate.saveOrUpdate(goods);
        return goods.getId();
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
