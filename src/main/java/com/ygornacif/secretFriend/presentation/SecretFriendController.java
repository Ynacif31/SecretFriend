package com.ygornacif.secretFriend.presentation;

import com.ygornacif.secretFriend.application.SecretFriendService;
import com.ygornacif.secretFriend.domain.model.SecretFriend;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secret-friend")
public class SecretFriendController {

    private final SecretFriendService secretFriendService;

    public SecretFriendController(SecretFriendService secretFriendService) {
        this.secretFriendService = secretFriendService;
    }

    @PostMapping
    public ResponseEntity<List<SecretFriend>> prizeDraw(){
        List<SecretFriend> users = secretFriendService.prizeDraw();
        return ResponseEntity.ok().body(users);
    }

}
