package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class PaymentRepository {

    public PaymentDataResponse postPayment(String userId, int price) {
        PaymentData paymentData = new PaymentData();
        paymentData.setUserId(userId);
        paymentData.setAmount(price);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:1123/payment", paymentData, PaymentDataResponse.class);
    }

    public List<Charge> postCharge() {
        RestTemplate restTemplate = new RestTemplate();
        ChargeResponseList result = restTemplate.postForObject("http://localhost:1123/charge", null, ChargeResponseList.class);
        return result.getChargeResponseList();
    }

}
