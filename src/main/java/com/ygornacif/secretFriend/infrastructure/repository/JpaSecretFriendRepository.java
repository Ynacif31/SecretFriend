package com.ygornacif.secretFriend.infrastructure.repository;

import com.ygornacif.secretFriend.domain.model.SecretFriend;
import com.ygornacif.secretFriend.domain.repository.SecretFriendRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSecretFriendRepository implements SecretFriendRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(SecretFriend secretFriend) {
        em.persist(secretFriend);
    }
}
