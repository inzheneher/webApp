package com.mav.user;

import com.mav.dao.GoodsDAO;
import com.mav.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

    public GoodsServiceImpl() {
        System.out.println("GoodsServiceImpl()");
    }

    @Override
    public long saveGoods(Goods goods) {
        return goodsDAO.saveGoods(goods);
    }

    @Override
    public void deleteGoods(long id) {
        goodsDAO.deleteGoods(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDAO.getAllGoods();
    }

    @Override
    public Goods getGoods(long id) {
        return goodsDAO.getGoods(id);
    }
}
