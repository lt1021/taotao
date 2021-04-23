package com.lt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lt.component.AuthenticationAccessDeniedHandler;
import com.lt.component.CustomMetadataSource;
import com.lt.component.UrlAccessDecisionManager;
import com.lt.entity.RespBean;
import com.lt.servlet.HrService;
import com.lt.utli.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lt
 * @date 2021/4/21 15:54
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .withObjectPostProcessor(new
                        ObjectPostProcessor<FilterSecurityInterceptor>() {

                            @Override
                            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                                o.setSecurityMetadataSource(metadataSource);
                                o.setAccessDecisionManager(urlAccessDecisionManager);
                                return o;
                            }
                        })
                .and()
                .formLogin()
                .loginPage("/login_p").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json; charset=UTF-8");
                        RespBean respBean = null;
                        if (e instanceof BadCredentialsException || e instanceof UsernameNotFoundException) {
                            respBean = RespBean.error("账户名或者密码错误");
                        } else if (e instanceof LockedException) {
                            respBean = RespBean.error("账户被锁定，请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
//                            respBean.setMsg("密码过期，请联系管理员!");
                        } else if (e instanceof AccountExpiredException) {
//                            respBean.setMsg("账户过期，请联系管理员!");
                        } else if (e instanceof DisabledException) {
//                            respBean.setMsg("账户被禁用，请联系管理员!");
                        } else if (e instanceof BadCredentialsException) {
//                            respBean.setMsg("用户名或者密码输入错误，请重新输入!");
                        }
                        resp.setStatus(401);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json; charset=UTF-8");
                        RespBean respBean = RespBean.ok("登陆成功", HrUtils.getCurrentHr());
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
    }
}
