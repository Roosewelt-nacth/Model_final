package com.example.login.controller;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.service.LogService;
import com.example.login.service.RegService;
import com.example.login.domain.Login;

@Controller
public class LogController {

    @Autowired
    private LogService service;
 
    @GetMapping("/")
    public String api2()
    {
        return "login";
    }

    @PostMapping("/log")
    public String Login(@ModelAttribute("user") Login user) {
        Login oauthUser = service.log(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/disp";
        } else {
            return "redirect:/";
        }
    }
 
    @GetMapping("/disp")
    public String display() {
        return "disp";
    }
    
 
    @Autowired
    private RegService rservice;
 
    @GetMapping("/register")
    public String api()
    {
 
        return "register";
    }

    @PostMapping("/reg")
    public String register(@ModelAttribute("user") Login user) {
 
        Login oauthUser = rservice.reg(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }
 
    @GetMapping("/display")
    public String display2() {
        return "display";
    }
 

   
}

