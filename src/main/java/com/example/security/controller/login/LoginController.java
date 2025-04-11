package com.example.security.controller.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        return "login/login";
    }

}
