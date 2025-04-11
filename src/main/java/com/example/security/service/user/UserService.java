package com.example.security.service.user;

import com.example.security.model.user.User;

public interface UserService {

    User selectUserByUsername(String username);
}
