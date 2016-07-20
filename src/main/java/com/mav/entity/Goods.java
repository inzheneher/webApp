package com.mav.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods")
public class Goods implements Serializable{
    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long goods_id;

    @Column
    private String goods_name;

    @Column
    private String goods_description;

    @Column
    private double goods_price;

    @Column
    private int goods_quantity;

    public Goods() {
    }

    public long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(long goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_description() {
        return goods_description;
    }

    public void setGoods_description(String goods_description) {
        this.goods_description = goods_description;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_quantity() {
        return goods_quantity;
    }

    public void setGoods_quantity(int goods_quantity) {
        this.goods_quantity = goods_quantity;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + goods_id +
                ", name=\"" + goods_name + "\'" +
                ", description=" + goods_description +
                ", price=" + goods_price +
                ", quantity=" + goods_quantity +
                "}";
    }
}
