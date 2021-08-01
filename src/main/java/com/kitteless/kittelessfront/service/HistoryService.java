package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.Charge;
import com.kitteless.kittelessfront.data.History;
import com.kitteless.kittelessfront.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public List<History> getHistoryData(String userID) {
        return historyRepository.postHistory(userID);
    }
}
