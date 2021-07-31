package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class EntryController {

    @Autowired
    EntryService entryService;

    @PostMapping(value = "/entry")
    public String entry(
            @RequestParam String stampCode,
            @RequestParam String image,
            Model model,
            HttpSession session
    ) {
        String userId = session.getAttribute("userId").toString();
        boolean result = entryService.entry(userId, stampCode, image);

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
