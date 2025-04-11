package com.example.security.model.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class CustomUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private User user;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(User user) {
        super(user.getUsername(), user.getPassword(), user.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth.getRole())).collect(Collectors.toList()));
        this.user = user;
    }
}
