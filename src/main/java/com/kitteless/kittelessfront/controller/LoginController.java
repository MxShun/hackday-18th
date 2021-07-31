package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ログイン画面
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        loginService.login(username, password);

        return "login";
    }

    @GetMapping(value = "/login")
    public String showLogin(
            Model model
    ) {
        return "login";
    }

}
