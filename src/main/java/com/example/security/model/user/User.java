package com.example.security.model.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class User {
    private long seq;
    private String id;
    private String username;
    private String password;
    private String name;
    private List<UserRole> roles;
    private LocalDate birth;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
