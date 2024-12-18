package com.ygornacif.secretFriend.application.dto;

import com.ygornacif.secretFriend.domain.model.User;
import java.util.Objects;

public class UserDTO {

    private Long id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
