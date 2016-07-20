package com.mav.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @Column
    private String user_name;

    @Column
    private String user_pass;

    @Column
    private boolean user_role;

    public User() {
    }
    public long getId() {
        return user_id;
    }
    public void setId(long user_id) {
        this.user_id = user_id;
    }
    public String getName() {
        return user_name;
    }
    public void setName(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_pass() {
        return user_pass;
    }
    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
    public boolean isUser_role() {
        return user_role;
    }
    public void setUser_role(boolean user_role) {
        this.user_role = user_role;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", name=\"" + user_name + "\'" +
                ", password=" + user_pass +
                ", role=" + user_role +
                "}";
    }
}
