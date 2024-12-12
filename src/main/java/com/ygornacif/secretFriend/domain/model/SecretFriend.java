package com.ygornacif.secretFriend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "secret_friend")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecretFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User participant;

    @ManyToOne
    private User friend;


}
