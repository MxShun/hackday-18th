package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Controller
public class EntryController {

    @Autowired
    EntryService entryService;

    @PostMapping(value = "/entry")
    public String login(
            // TODO: stampCodeは必須なので直す
            @RequestParam(required = false) String stampCode,
            @RequestParam MultipartFile image,
            Model model
    ) {
        try {
            byte[] bytes = image.getBytes();
            String str = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {}
        // boolean result = entryService.entry(stampCode, image);
        // if (result) {
        //     return "redirect:[OCR結果確認+認証]";
        // }

        return "entry";
    }

    @GetMapping(value = "/entry")
    public String entryRegister(
            Model model
    ) {
        return "entry";
    }
}
