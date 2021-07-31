package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.PaymentData;
import com.kitteless.kittelessfront.data.PaymentDataResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PaymentRepository {
    private RestTemplate restTemplate;

    public PaymentDataResponse post (String userId, int price) {
        PaymentData paymentData = new PaymentData();
        paymentData.setUserId(userId);
        paymentData.setAmount(price);

        return stub();
        // return restTemplate.postForObject("http://localhost:1123/payment", paymentData, PaymentDataResponse.class);
    }

    private PaymentDataResponse stub() {
        PaymentDataResponse paymentDataResponse = new PaymentDataResponse();
        paymentDataResponse.setPaymentResult("success");
        paymentDataResponse.setStampCode("123456789");
        return paymentDataResponse;
    }
}
