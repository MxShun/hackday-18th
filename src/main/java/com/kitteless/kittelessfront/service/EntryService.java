package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.OCRDataResponse;
import com.kitteless.kittelessfront.data.StampAuthorizeDataResponse;
import com.kitteless.kittelessfront.repository.EntryRepository;
import com.kitteless.kittelessfront.repository.StampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    StampRepository stampRepository;

    public boolean entry(String userId, String stampCode, String image) {
        OCRDataResponse result = entryRepository.post(image);

        if (!result.getResult().equals("success")) {
            return false;
        }

        String ocrStampCode = result.getText();

        // OCRの解析結果ともとの切手コードの照合して異なっていた場合は失敗
        if (!stampCode.equals(ocrStampCode)) {
            return false;
        }

        StampAuthorizeDataResponse stampAuthorizeDataResponse = stampRepository.authorize(userId, stampCode);

        if (stampAuthorizeDataResponse.getResult().equals("success")) {
            return true;
        }

        return false;
    }
}
