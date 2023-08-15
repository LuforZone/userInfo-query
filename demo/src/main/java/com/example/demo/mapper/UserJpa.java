package com.example.demo.mapper;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserJpa extends JpaRepository<User, Integer> {
    void deleteByEmail(String email);
}