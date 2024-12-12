package com.ygornacif.secretFriend.application;

import com.ygornacif.secretFriend.domain.model.SecretFriend;
import com.ygornacif.secretFriend.domain.model.User;
import com.ygornacif.secretFriend.domain.repository.SecretFriendRepository;
import com.ygornacif.secretFriend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.shuffle;

@Service
public class SecretFriendService {

    private final SecretFriendRepository secretFriendRepository;

    private final UserRepository userRepository;

    public SecretFriendService(SecretFriendRepository secretFriendRepository, UserRepository userRepository) {
        this.secretFriendRepository = secretFriendRepository;
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<SecretFriend> prizeDraw() {
        List<User> participants = userRepository.findAll();

        if(participants.size() < 2){
            throw new RuntimeException("There must be at least two participants to draw the prize");
        }

        List<User> friends = new ArrayList<>();
        Collections.shuffle(participants);

        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).equals(friends.get(i))) {
                Collections.shuffle(friends);
                i = -1;
            }
        }
        return prizeDraw();
    }
}
