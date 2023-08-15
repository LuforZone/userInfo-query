package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserJpa;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {
    private  UserMapper userMapper;
    private  UserJpa userJpa;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public UserService(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    public User getUserByEmail(String email){
        return userMapper.findByEmail(email);
    }
    public User addUser(User user){
        userJpa.save(user);
        return null;
    }
    public void deleteUserByEmail(String email) {
        userJpa.deleteByEmail(email);
    }
    public void updateUserByEmail(String email, User user) {
        userJpa.save(user);
    }
}
