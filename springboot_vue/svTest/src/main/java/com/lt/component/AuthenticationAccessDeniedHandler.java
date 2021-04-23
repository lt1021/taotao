package com.lt.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lt.entity.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lt
 * @date 2021/4/21 16:24
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        RespBean error = RespBean.error("权限不足，请联系管理员");
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }
}
