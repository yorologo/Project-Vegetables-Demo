package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    String loginView() {
        return "user/login";
    }

    @GetMapping("/registro")
    String registerView() {
        return "user/register";
    }

    @GetMapping("/recuperar")
    String recoverView() {
        return "user/pswd_lost";
    }

    @GetMapping("/reiniciar")
    String resetView() {
        return "user/pswd_reset";
    }
}
