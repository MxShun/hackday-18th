package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.OCRVerifyResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MatchRepository {

    public OCRVerifyResponse post(String image) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:1123/stamp/verify", image, OCRVerifyResponse.class);
    }

}
