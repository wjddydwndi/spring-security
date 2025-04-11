package com.example.security.service.user;

import com.example.security.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public User selectUserByUsername(String username) {
        return null;
    }
}
