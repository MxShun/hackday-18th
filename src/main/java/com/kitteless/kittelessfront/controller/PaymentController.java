package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.data.Stamp;
import com.kitteless.kittelessfront.presenter.StampPresenter;
import com.kitteless.kittelessfront.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        if (price == null) {
            model.addAttribute("result", false);
            model.addAttribute("errorDetail", "金額を入力してください");
            return "payment";
        }

        if (session.getAttribute("userId") == null) {
            session.setAttribute("userId", "hoge");
        }
        String userId = session.getAttribute("userId").toString();
        Stamp stamp = paymentService.getStampWithPayment(userId, price);

        if(stamp != null) {
            session.setAttribute("stampCode", stamp.getCode());
            String url = paymentService.paypay(userId, price);
            redirectAttributes.addFlashAttribute("url", url);
            return "redirect:/paypay";
        }

        model.addAttribute("result", false);
        model.addAttribute("errorDetail", "金額を入力してください");
        return "payment";
    }

    @RequestMapping("/paypay")
    public RedirectView localRedirect(@ModelAttribute("url") String url) {
        System.out.println("URL === " + url);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }

    @GetMapping(value = "/payment")
    public String showPayment(
            Model model
    ) {
        model.addAttribute("stampList", paymentService.getChargeData());
        return "payment";
    }
}
