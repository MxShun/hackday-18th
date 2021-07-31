package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.PaymentData;
import com.kitteless.kittelessfront.data.PaymentDataResponse;
import com.kitteless.kittelessfront.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public boolean payment(String userId, int price) {
        PaymentDataResponse result = paymentRepository.post(userId, price);

        if (result.getPaymentResult().equals("success")) {
            return true;
        }

        return false;
    }
}
