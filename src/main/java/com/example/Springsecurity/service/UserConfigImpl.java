package com.example.Springsecurity.service;


import com.example.Springsecurity.config.CustomUserDetails;
import com.example.Springsecurity.dao.CourseDao;

import com.example.Springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserConfigImpl implements UserDetailsService {

    @Autowired
    private CourseDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //fetching user from daabase
        User user=dao.getUserDetailsByUserName(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Could not found user ");
        }
        CustomUserDetails customUserDetails=new CustomUserDetails(user);

        return customUserDetails;
    }
    }


