package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.presenter.StampPresenter;
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
            @RequestParam MultipartFile image,
            Model model,
            HttpSession session
    ) {
        String imageString = "";
        String stampCode = session.getAttribute("stampCode").toString();

        try {
            byte[] imgBytes = image.getBytes();

            if (imgBytes.length == 0) {
                StampPresenter stampPresenter = new StampPresenter(stampCode);
                model.addAttribute(stampPresenter);
                model.addAttribute("result", false);
                return "entry";
            }

            imageString = Base64.getEncoder().encodeToString(imgBytes);
        } catch (Exception e) {

        }
        if (session.getAttribute("userId") == null) {
            session.setAttribute("userId", "hoge");
        }
        String userId = session.getAttribute("userId").toString();
        boolean result = entryService.entry(userId, stampCode, imageString);
        
        if (result) {
            return "redirect:complete";
        }

        StampPresenter stampPresenter = new StampPresenter(stampCode);
        model.addAttribute(stampPresenter);
        model.addAttribute("result", false);
        return "entry";
    }

    @GetMapping(value = "/entry")
    public String showEntry(
            Model model,
            HttpSession session
    ) {
        if (session.getAttribute("stampCode") == null) {
            return "redirect:/payment";
        }

        String stampCode = session.getAttribute("stampCode").toString();

        StampPresenter stampPresenter = new StampPresenter(stampCode);
        model.addAttribute(stampPresenter);
        return "entry";
    }
}
