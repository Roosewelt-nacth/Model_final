package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.domain.Login;
import com.example.login.repository.LogRepo;


@Service
public class RegService {
    @Autowired
    private LogRepo rep;
    
    public Login  reg(String username,String password){
        Login user = new Login ();
        user.setUsername(username);
        user.setPassword(password);
        return rep.save(user);
    }
}
