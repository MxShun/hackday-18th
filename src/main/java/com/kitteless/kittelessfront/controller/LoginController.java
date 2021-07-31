package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.service.LoginService;
import javax.servlet.http.HttpSession;
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
            Model model,
            HttpSession session
    ) {
        String userId = loginService.login(username, password);
        if (userId != null) {
            // セッションにユーザIDを入れる
            session.setAttribute("userId", userId);
            return "redirect:payment";
        }

        // ログインに失敗したら login: false を model にセットするので、画面側でこれを使って失敗したことを表示する
        model.addAttribute("login", false);
        return "login";
    }

    @GetMapping(value = "/login")
    public String showLogin() {
        return "login";
    }

}
