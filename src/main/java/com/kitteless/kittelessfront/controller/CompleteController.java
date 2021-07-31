package com.kitteless.kittelessfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログイン画面
 */
@Controller
public class CompleteController {

    @GetMapping(value = "/complete")
    public String complete() {
        return "complete";
    }
}
