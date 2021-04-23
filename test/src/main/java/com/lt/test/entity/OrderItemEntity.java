package com.lt.test.entity;

import java.util.List;

/**
 * @author lt
 * @date 2021/4/19 12:06
 */
public class OrderItemEntity {
    public Long id;
    public List<OrderItem> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }
}
