package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.OCRDataResponse;
import com.kitteless.kittelessfront.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public boolean match(String image) {
        OCRDataResponse result = matchRepository.post(image);

        if (result.getResult().equals("success")) {
            return true;
        }

        return false;
    }
}
