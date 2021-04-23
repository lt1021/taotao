package com.lt.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lt
 * @date 2021/4/19 17:57
 */
@WebFilter
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter>>doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter>>init");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter>>destroy");
    }
}
