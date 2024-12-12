package com.ygornacif.secretFriend.domain.repository;

import com.ygornacif.secretFriend.domain.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
}
