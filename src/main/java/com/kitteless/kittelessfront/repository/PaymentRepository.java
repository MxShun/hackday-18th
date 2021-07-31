package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.PaymentData;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PaymentRepository {
    private RestTemplate restTemplate;

    public String post (int price) {
        PaymentData paymentData = restTemplate.getForObject("API", PaymentData.class);

        return "success";
    }
}
