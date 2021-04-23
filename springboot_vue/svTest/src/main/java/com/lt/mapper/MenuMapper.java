package com.lt.mapper;

import com.lt.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lt
 * @date 2021/4/21 16:57
 */
@Mapper
public interface MenuMapper {
    List<Menu> getAllMenu();
}
