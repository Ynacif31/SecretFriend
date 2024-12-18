package com.ygornacif.secretFriend.infrastructure.repository;

import com.ygornacif.secretFriend.domain.model.User;
import com.ygornacif.secretFriend.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
