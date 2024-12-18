package com.ygornacif.secretFriend.presentation;

import com.ygornacif.secretFriend.application.SecretFriendService;
import com.ygornacif.secretFriend.application.UserService;
import com.ygornacif.secretFriend.application.dto.UserDTO;
import com.ygornacif.secretFriend.domain.model.User;
import com.ygornacif.secretFriend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final SecretFriendService secretFriendService;

    public UserController(UserService userService, UserRepository userRepository, SecretFriendService secretFriendService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.secretFriendService = secretFriendService;
    }

    // Correção: Removido "/users" para evitar duplicação
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(user -> new UserDTO(user))
                .toList();
        return ResponseEntity.ok(userDTOs);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
        UserDTO newDto = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }
}