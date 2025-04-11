package com.example.security.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRole {

    private long seq;
    private String role;
    private String detail;

    public UserRole(String role) {
        this.role = role;
    }
}
