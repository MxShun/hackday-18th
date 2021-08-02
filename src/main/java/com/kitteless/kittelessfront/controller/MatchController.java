package com.kitteless.kittelessfront.controller;
import com.kitteless.kittelessfront.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
@Controller
public class MatchController {
    @Autowired
    MatchService matchService;
    @PostMapping(value = "/post-office/match")
    public String entry(
            @RequestParam MultipartFile image,
            Model model
    ) {
        String imageString = "";
        try {
            byte[] imgBytes = image.getBytes();
            imageString = Base64.getEncoder().encodeToString(imgBytes);
        } catch (Exception e) {
        }
        boolean result = matchService.match(imageString);
        if (result) {
            return "redirect:/post-office/approve";
        }

        model.addAttribute("result", false);
        return "/post-office/match";
    }
    @GetMapping(value = "/post-office/match")
    public String showEntry(
            Model model
    ) {
        return "/post-office/match";
    }
}

