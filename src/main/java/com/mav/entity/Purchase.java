package com.mav.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "purchase")
public class Purchase implements Serializable{
    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long purchase_id;

    @Column
    private int user_id;

    @Column
    private int goods_id;

    @Column
    private Date purchase_date;

    @Column
    private double purchase_prise;

    @Column
    private int purchase_quantity;

    public Purchase() {
    }

    public long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public double getPurchase_prise() {
        return purchase_prise;
    }

    public void setPurchase_prise(double purchase_prise) {
        this.purchase_prise = purchase_prise;
    }

    public int getPurchase_quantity() {
        return purchase_quantity;
    }

    public void setPurchase_quantity(int purchase_quantity) {
        this.purchase_quantity = purchase_quantity;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + purchase_id +
                ", user=" + user_id +
                ", goods=" + goods_id +
                ", date=" + purchase_date +
                ", price=" + purchase_prise +
                ", quantity=" + purchase_quantity +
                "}";
    }
}
