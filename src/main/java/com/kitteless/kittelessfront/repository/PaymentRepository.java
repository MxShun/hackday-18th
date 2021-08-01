package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.ChargeData;
import com.kitteless.kittelessfront.data.PaymentData;
import com.kitteless.kittelessfront.data.PaymentDataResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepository {

    public PaymentDataResponse postPayment(String userId, int price) {
        PaymentData paymentData = new PaymentData();
        paymentData.setUserId(userId);
        paymentData.setAmount(price);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:1123/payment", paymentData, PaymentDataResponse.class);
    }

    public ChargeData postCharge() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:1123/charge", null, ChargeData.class);
    }

    private ChargeData stub() {
        Map<Integer, String> map = new HashMap<>() {
            {
                put(84, "25g");
                put(94, "50g");
                put(63, "通常はがき");
                put(126, "往復はがき");
            }
        };
        ChargeData chargeData = new ChargeData();
        chargeData.setCharge(map);
        return chargeData;
    }

}
