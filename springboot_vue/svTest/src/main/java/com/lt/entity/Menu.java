package com.lt.entity;

import lombok.Data;

import java.util.List;

/**
 * @author lt
 * @date 2021/4/21 16:04
 */
@Data
public class Menu {
    private String url;

    private List<Role> roles;
}
