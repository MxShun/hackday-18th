package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.service.LoginService;
import com.kitteless.kittelessfront.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * アカウント登録
 */
@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping(value = "/register")
    public String login() {
        // TODO: リクエストでユーザ名とか受け取ったりする

        // TODO: serviceできあがりしだい呼び出す
        registerService.register();

        // TODO: レスポンスにsetAttributeしたりする
        return "register";
    }
}
