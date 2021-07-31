package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.data.Stamp;
import com.kitteless.kittelessfront.presenter.StampPresenter;
import com.kitteless.kittelessfront.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 決済登録
 */
@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/payment")
    public String payment(
            @RequestParam(required = false) Integer price,
            Model model,
            HttpSession session
    ) {
        if (price == null) {
            model.addAttribute("result", false);
            model.addAttribute("errorDetail", "金額を入力してください");
            return "payment";
        }

        String userId = session.getAttribute("userId").toString();
        Stamp stamp = paymentService.getStampWithPayment(userId, price);

        if(stamp != null) {
            session.setAttribute("stampCode", stamp.getCode());
            return "redirect:entry";
        }

        model.addAttribute("result", false);
        model.addAttribute("errorDetail", "");
        return "payment";
    }

    @GetMapping(value = "/payment")
    public String showPayment() {
        return "payment";
    }
}
