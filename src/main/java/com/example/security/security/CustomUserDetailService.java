package com.example.security.security;

import com.example.security.model.user.CustomUser;
import com.example.security.model.user.User;
import com.example.security.model.user.UserRole;
import com.example.security.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<UserRole> list = new ArrayList<>();
        list.add(new UserRole("ROLE_USER"));
        user.setRoles(list);

        return new CustomUser(user);
    }
}
