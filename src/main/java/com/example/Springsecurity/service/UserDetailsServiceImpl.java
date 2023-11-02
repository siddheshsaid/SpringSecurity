package com.example.Springsecurity.service;

import com.example.Springsecurity.dao.CourseDao;
import com.example.Springsecurity.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserService{
    @Autowired
    private CourseDao courseDao;
    @Override
    public User addUser(User user) {
//        list.add(course);
        courseDao.save(user);
        return user;
    }




}

































































































































