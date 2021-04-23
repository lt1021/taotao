package com.lt.entity;

import lombok.Data;

/**
 * @author lt
 * @date 2021/4/19 16:38
 */
@Data
public class Book {
    private String name;
    private String  author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
