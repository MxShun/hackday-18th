package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.OCRDataResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EntryRepository {

    public OCRDataResponse post(String image) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://localhost:1123/extract", image, OCRDataResponse.class);
    }

    private OCRDataResponse stub() {
        OCRDataResponse ocrDataResponse = new OCRDataResponse();
        ocrDataResponse.setText("123456789");
        ocrDataResponse.setResult("success");
        return ocrDataResponse;
    }
}
