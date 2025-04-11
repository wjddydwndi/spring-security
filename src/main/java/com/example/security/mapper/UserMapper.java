package com.example.security.mapper;

import com.example.security.model.user.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserByUsername(@Param("username") String username);
}
