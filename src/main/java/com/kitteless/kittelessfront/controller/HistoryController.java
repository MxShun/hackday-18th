package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.data.HistoryList;
import com.kitteless.kittelessfront.presenter.StampPresenter;
import com.kitteless.kittelessfront.service.EntryService;
import com.kitteless.kittelessfront.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping(value = "/history")
    public String showHistory(
            Model model,
            HttpSession session
    ) {

        String userId = session.getAttribute("userId").toString();

        HistoryList historyList = historyService.getHistoryData(userId);

        model.addAttribute("historyList", historyList.getHistoryResponseList());
        return "history";
    }
}
