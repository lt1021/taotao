package com.lt.entity;

import lombok.Data;

/**
 * @author lt
 * @date 2021/4/19 16:39
 */
@Data
public class Author {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
