package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.Charge;
import com.kitteless.kittelessfront.data.ChargeData;
import com.kitteless.kittelessfront.data.PaymentData;
import com.kitteless.kittelessfront.data.PaymentDataResponse;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<Charge> postCharge() {
        RestTemplate restTemplate = new RestTemplate();
        return stub();
        //return restTemplate.postForObject("http://localhost:1123/charge", null, ChargeData.class);
    }

    private List<Charge> stub() {
        List<Charge> chargeList = new ArrayList<>();
        Charge charge = new Charge();
        charge.setFee(84);
        charge.setType("5gまで");
        chargeList.add(charge);
        charge = new Charge();
        charge.setFee(94);
        charge.setType("15gまで");
        chargeList.add(charge);
        charge.setFee(150);
        charge.setType("25gまで");
        chargeList.add(charge);
        charge = new Charge();
        charge.setFee(180);
        charge.setType("35gまで");
        chargeList.add(charge);
        charge = new Charge();
        charge.setFee(200);
        charge.setType("95gまで");
        chargeList.add(charge);
        charge = new Charge();
        charge.setFee(250);
        charge.setType("5kgまで");
        chargeList.add(charge);
        return chargeList;
    }
}
