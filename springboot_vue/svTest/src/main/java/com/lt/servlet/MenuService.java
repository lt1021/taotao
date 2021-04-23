package com.lt.servlet;

import com.lt.entity.Menu;
import com.lt.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lt
 * @date 2021/4/21 16:03
 */
@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }
}
