package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/findAll")
    public List<User> getAllUser(){
        return  userService.findAll();
    }
}