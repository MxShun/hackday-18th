package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.PaymentData;
import com.kitteless.kittelessfront.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public boolean payment(int price) {
         String result = paymentRepository.post(price);

        if (result.equals("success")) {
            return true;
        }

        return false;
    }
}
