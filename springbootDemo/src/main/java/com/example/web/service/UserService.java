package com.example.web.service;

import com.example.web.entity.User;

import java.util.List;

public interface  UserService {

    List<User> findAll();

    User getUserById(int id);

    void addUser(User user);

    int editUser(User user);

    int deleteUser(int id);
}
