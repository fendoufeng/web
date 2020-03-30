package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
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

        User user =  userService.getUserById(2);
        if (user == null){
            System.out.println("ccc");
            return  null;
        } else {
            return user;
        }

    }

    @RequestMapping("/addUser")
    public void addUser(){
       String username = "jiafeng";
       String password = "123456";
       User user = new User();
       user.setUsername(username);
       user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
       user.setCreate_time(new Date(System.currentTimeMillis()));
       userService.addUser(user);
    }

    @RequestMapping("/editUser")
    public String  editUser(){
        User user = new User();
        user.setBrithday(Date.valueOf("1995-09-21"));
        user.setEmail("498304115@qq.com");
        int result = userService.editUser(user);
        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(){
        int result = userService.deleteUser(3);
        if (result > 0){
            return "delete success";
        } else {
            return "delete fail";
        }
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(){
        String username = "jiafeng";
        String oldPassword1 = "123456";
        String oldPassword2 = "123456";
        String newPassword = "123456";

        boolean result = userService.updatePassword(username,oldPassword1,oldPassword2,newPassword);

        if (result){
            return "success";
        } else {
            return "fail,all reason";
        }
    }

    @RequestMapping("/updatePersonalInfo")
    public String updatePersonalInfo(){

        User user = userService.getUserById(4);

        user.setPassword("aaaa");
        user.setEmail("1111@123.com");
        user.setNickname("jf");

        boolean result = userService.updatePersonalInfo(user);
        if (result){
            return  "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping("/login")
    public String logIn(User user, HttpServletRequest request){
        boolean flag = true;

        flag = userService.logIn(user.getUsername(),user.getPassword());

        if (flag){
            request.getSession().setAttribute("_session_user",user);
            return "登录成功";
       }
        return "登录失败";

    }


}
