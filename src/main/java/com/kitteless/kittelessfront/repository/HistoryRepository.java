package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.HistoryList;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class HistoryRepository {

    public HistoryList postHistory(String userID) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:1123/history", userID, HistoryList.class);
    }

}
