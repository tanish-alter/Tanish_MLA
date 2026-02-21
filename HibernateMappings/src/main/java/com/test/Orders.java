package com.test;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")  // changed table name (order is reserved)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String o_name;

    private int o_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")   // fixed annotation + column name
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getO_name() {
        return o_name;
    }

    public void setO_name(String o_name) {
        this.o_name = o_name;
    }

    public int getO_price() {
        return o_price;
    }

    public void setO_price(int o_price) {
        this.o_price = o_price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}