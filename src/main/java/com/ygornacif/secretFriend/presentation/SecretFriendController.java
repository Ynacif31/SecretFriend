package com.ygornacif.secretFriend.presentation;

import com.ygornacif.secretFriend.application.SecretFriendService;
import com.ygornacif.secretFriend.domain.model.SecretFriend;
import com.ygornacif.secretFriend.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secret-friend")
public class SecretFriendController {

    private final SecretFriendService secretFriendService;

    public SecretFriendController(SecretFriendService secretFriendService) {
        this.secretFriendService = secretFriendService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = secretFriendService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/prize-draw")
    public ResponseEntity<List<SecretFriend>> prizeDraw(){
        List<SecretFriend> users = secretFriendService.prizeDraw();
        return ResponseEntity.ok().body(users);
    }

}
