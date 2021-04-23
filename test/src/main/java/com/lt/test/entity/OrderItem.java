package com.lt.test.entity;

import java.io.Serializable;

/**
 * @author lt
 * @date 2021/4/19 12:07
 */
public class OrderItem implements Serializable {
    private String column;
    private boolean asc = true;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public OrderItem() {
    }

    public OrderItem(String column, boolean asc) {
        this.column = column;
        this.asc = asc;
    }
}
