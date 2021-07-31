package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.OCRDataResponse;
import com.kitteless.kittelessfront.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    // うごかない MatchRepositoryが見つからないらしい
    // -> matchrepository に @Repository　アノテーションつけたよ
    @Autowired
    MatchRepository matchRepository;

    public boolean entry(String stampCode, String image) {
        OCRDataResponse result = matchRepository.post(image);

        if (!result.getResult().equals("success")) {
            return false;
        }

        String ocrStampCode = result.getText();

        if (!stampCode.equals(ocrStampCode)) {
            return false;
        }


        // ok判定わからん
        return true;
    }
}
