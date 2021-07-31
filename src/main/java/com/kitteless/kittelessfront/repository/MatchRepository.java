package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.OCRData;
import com.kitteless.kittelessfront.data.OCRDataResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MatchRepository {

    public OCRDataResponse post(String image) {
        OCRData ocrData = new OCRData();
        ocrData.setImage(image);

        RestTemplate restTemplate = new RestTemplate();
        return stub();

        // return restTemplate.postForObject("http://localhost:1123/stamp/verify", ocrData, OCRDataResponse.class);
    }

    private OCRDataResponse stub() {
        OCRDataResponse ocrDataResponse = new OCRDataResponse();
        ocrDataResponse.setText("imageData");
        ocrDataResponse.setResult("success");
        return ocrDataResponse;
    }
}
