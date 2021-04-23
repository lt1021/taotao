package com.lt.component;

import com.lt.entity.Menu;
import com.lt.entity.Role;
import com.lt.servlet.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author lt
 * @date 2021/4/21 15:33
 * 这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String reqUrl = ((FilterInvocation)o).getRequestUrl();
        List<Menu> allMenu = menuService.getAllMenu();
        for (Menu menu: allMenu) {
            if (antPathMatcher.match(menu.getUrl(),reqUrl)) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String [] val = new String[size];
                for (int i = 0; i < size; i++) {
                    val[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(val);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
