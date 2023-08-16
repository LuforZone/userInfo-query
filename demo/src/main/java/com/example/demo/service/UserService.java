package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserJpa;
import com.example.demo.mapper.UserMapper;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Transactional
    public User addUser(User user) {
        userMapper.save(user);
        return null;
    }

    public void deleteUserByEmail(String email) {
        userMapper.deleteByEmail(email);
    }

    public void updateUserByEmail(String email, User user) {
        user.setEmail(email);
        System.out.println(user.getPassword() + " " + user.getUserName() + " " + user.getPassword());
        System.out.println(user.getEmail());
        userMapper.updateUser(user);

    }
}
