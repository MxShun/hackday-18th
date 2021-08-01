package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.Charge;
import com.kitteless.kittelessfront.data.History;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryRepository {

    public List<History> postHistory(String userID) {

        RestTemplate restTemplate = new RestTemplate();
        return stub();
//        return (List<History>) restTemplate.postForObject("http://localhost:1123/history", userID, History.class);
    }

    private List<History> stub() {
        List<History> historyList = new ArrayList<>();
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setFee(84);
        historyList.add(history);
        history = new History();
        history.setDate(LocalDateTime.now());
        history.setFee(154);
        historyList.add(history);
        history = new History();
        history.setDate(LocalDateTime.now());
        history.setFee(54);
        historyList.add(history);
        history = new History();
        history.setDate(LocalDateTime.now());
        history.setFee(284);
        historyList.add(history);
        return historyList;
    }
}
