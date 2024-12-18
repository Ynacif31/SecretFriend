package com.ygornacif.secretFriend.application;

import com.ygornacif.secretFriend.domain.model.SecretFriend;
import com.ygornacif.secretFriend.domain.model.User;
import com.ygornacif.secretFriend.domain.repository.SecretFriendRepository;
import com.ygornacif.secretFriend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class SecretFriendService {

    private final SecretFriendRepository secretFriendRepository;
    private final UserRepository userRepository;

    public SecretFriendService(SecretFriendRepository secretFriendRepository, UserRepository userRepository) {
        this.secretFriendRepository = secretFriendRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<SecretFriend> prizeDraw() {
        List<User> participants = userRepository.findAll();

        if (participants.size() < 2) {
            throw new IllegalArgumentException("There must be at least two participants to draw the prize");
        }

        List<User> shuffledParticipants = new ArrayList<>(participants);
        Collections.shuffle(shuffledParticipants);

        // Garantir que ninguém seja seu próprio amigo secreto
        Map<User, User> secretFriendMap = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            User participant = participants.get(i);
            User secretFriend = shuffledParticipants.get(i);

            if (participant.equals(secretFriend)) {
                // Embaralha novamente se alguém pegou a si mesmo
                Collections.shuffle(shuffledParticipants);
                i = -1; // Reinicia o loop
                continue;
            }
            secretFriendMap.put(participant, secretFriend);
        }

        // Salvar relações no banco de dados
        List<SecretFriend> result = new ArrayList<>();
        for (Map.Entry<User, User> entry : secretFriendMap.entrySet()) {
            SecretFriend relation = new SecretFriend();
            relation.setParticipant(entry.getKey());
            relation.setFriend(entry.getValue());
            result.add(secretFriendRepository.save(relation));
        }

        return result;
    }

}