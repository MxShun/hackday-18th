package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.PaymentData;
import com.kitteless.kittelessfront.data.PaymentDataResponse;
import com.kitteless.kittelessfront.data.StampAuthorizeData;
import com.kitteless.kittelessfront.data.StampAuthorizeDataResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StampRepository {

    public StampAuthorizeDataResponse authorize(String userId, String stampCode) {
        StampAuthorizeData stampAuthorizeData = new StampAuthorizeData();
        stampAuthorizeData.setUserId(userId);
        stampAuthorizeData.setStampCode(stampCode);

        RestTemplate restTemplate = new RestTemplate();
        return stub();
        // return restTemplate.postForObject("http://localhost:1123/payment", stampAuthorizeData, StampAuthorizeDataResponse.class);
    }

    private StampAuthorizeDataResponse stub() {
        StampAuthorizeDataResponse stampAuthorizeDataResponse = new StampAuthorizeDataResponse();
        stampAuthorizeDataResponse.setResult("success");
        return stampAuthorizeDataResponse;
    }
}
