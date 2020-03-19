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

    @RequestMapping("/getUserById")
    public User getUserById(){
        return userService.getUserById(2);
    }

    @RequestMapping("/addUser")
    public void addUser(){
        User user = new User();
        user.setPassword("4444");
        user.setUsername("gggg");
        userService.addUser(user);
    }

    @RequestMapping("/editUser")
    public String  editUser(){
        User user = new User();
        user.setId(3);
        user.setPassword("66666");
        user.setUsername("gggg");
        int result = userService.editUser(user);
        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(){
        int result = userService.deleteUser(2);
        if (result > 0){
            return "delete success";
        } else {
            return "delete fail";
        }
    }

}
