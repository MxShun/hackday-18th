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

import javax.servlet.http.HttpSession;

@Controller
public class EntryController {

    @Autowired
    EntryService entryService;

    @PostMapping(value = "/entry")
    public String entry(
            // TODO: stampCodeは必須なので直す
            @RequestParam(required = false) String stampCode,
            @RequestParam MultipartFile image,
            Model model,
            HttpSession session
    ) {
        try {
            byte[] imgBytes = image.getBytes();
            String imgStr = Base64.getEncoder().encodeToString(imgBytes);
        } catch (Exception e) {}
        String userId = session.getAttribute("userId").toString();
        boolean result = entryService.entry(userId, stampCode, imgStr);
        
        if (result) {
            return "redirect:complete";
        }

        model.addAttribute("result", false);
        return "entry";
    }

    @GetMapping(value = "/entry")
    public String showEntry() {
        return "entry";
    }
}
