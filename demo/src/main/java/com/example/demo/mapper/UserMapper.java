package com.example.demo.mapper;

import com.example.demo.entity.User;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserMapper {
    @PersistenceContext
    private EntityManager entityManager;

    public User findByEmail(String email) {
        String jpql = "SELECT u FROM User u WHERE u.email = :email";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        System.out.println("findUserMapper " + users.isEmpty() != null ? null : users.get(0));
        return users.isEmpty() ? null : users.get(0);

    }

    public void save(User user) {
        System.out.println("saveUserMapper = " + user);
        entityManager.persist(user);
    }

    @Transactional
    public void deleteByEmail(String email) {
        User user = findByEmail(email);
        System.out.println("deleteUserMapper = " + user);
        entityManager.remove(user);
    }

    @Transactional
    public void updateUser(User user) {
        String email = user.getEmail();
        User existingUser = findByEmail(email);
        if (existingUser != null) {
            // 更新现有用户记录
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            // ... 其他属性的更新
            
            entityManager.merge(existingUser);
            System.out.println("updateUserMapper = " + existingUser);
        } else {
            // 插入新用户记录
            entityManager.persist(user);
            System.out.println("updateUserMapper = " + user);
        }
    }
}
