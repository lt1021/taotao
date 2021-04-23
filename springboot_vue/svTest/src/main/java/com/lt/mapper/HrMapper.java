package com.lt.mapper;

import com.lt.entity.Hr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author lt
 * @date 2021/4/21 15:16
 */
@Mapper
public interface HrMapper   {


    Hr loadUserByUserName(String s);
}
