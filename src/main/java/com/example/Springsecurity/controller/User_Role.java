package com.example.Springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class User_Role {
    @RequestMapping("/index")
    public String Login(Principal principal){
       String username= principal.getName();  //WILL GIVE VALUE OF USERNAME
        System.out.println("Username"+username);
        return "resultuser";
    }

}
