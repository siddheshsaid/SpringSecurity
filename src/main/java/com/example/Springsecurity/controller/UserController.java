package com.example.Springsecurity.controller;

import com.example.Springsecurity.model.User;

import com.example.Springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userDetailsService;
    @RequestMapping("/login")
    public ModelAndView dashboard()
    {
        ModelAndView mv=new ModelAndView();

        mv.addObject("User",new User());
        mv.setViewName("home");
        return mv;

    }
    @RequestMapping(value="/createlogin",method = RequestMethod.POST)
    public ModelAndView createLogin(@ModelAttribute("User") User user){
    ModelAndView mv=new ModelAndView();
    if(user!=null){
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDetailsService.addUser(user);
    }
    else{
        System.out.println("Something wrong is happen data is not saving in database");
    }
    mv.addObject("User",user);
    mv.setViewName("home");
        return mv;
    }

}
