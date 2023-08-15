package com.example.demo.mapper;

import com.example.demo.entity.User;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
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
        System.out.println(users.isEmpty() ? null : users.get(0));
        return users.isEmpty() ? null : users.get(0);

    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void deleteByEmail(String email) {
        User user = findByEmail(email);
        entityManager.remove(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
