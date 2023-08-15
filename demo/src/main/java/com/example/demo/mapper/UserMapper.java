package com.example.demo.mapper;

import com.example.demo.entity.User;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class UserMapper {
    @PersistenceContext
    private EntityManager entityManager;
    public User findByEmail(String email) {
        String jpql = "SELECT u FROM infos u WHERE u.email = :email";
        Query query = entityManager.createQuery(jpql, User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);

    }

    public User addUser(User user) {
        return null;
    }

}
