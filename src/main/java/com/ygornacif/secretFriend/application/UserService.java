package com.ygornacif.secretFriend.application;

import com.ygornacif.secretFriend.application.dto.UserDTO;
import com.ygornacif.secretFriend.domain.model.User;
import com.ygornacif.secretFriend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    public UserDTO insert(UserDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}
