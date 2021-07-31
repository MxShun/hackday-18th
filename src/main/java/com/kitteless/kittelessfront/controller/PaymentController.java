package com.kitteless.kittelessfront.controller;

import com.kitteless.kittelessfront.service.PaymentService;
import com.kitteless.kittelessfront.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 決済登録
 */
@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/payment")
    public String payment(
            @RequestParam Integer price,
            Model model
    ) {
        // TODO: 支払い金額を処理
        paymentService.payment(price);
        // TODO: レスポンスにsetAttributeしたりする
        return "payment";
    }

    @GetMapping(value = "/payment")
    public String showPayment(
            Model model
    ) {
        return "payment";
    }
}
