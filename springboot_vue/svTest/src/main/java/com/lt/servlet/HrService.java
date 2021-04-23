package com.lt.servlet;

import com.lt.entity.Hr;
import com.lt.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lt
 * @date 2021/4/21 15:14
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr =  hrMapper.loadUserByUserName(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
