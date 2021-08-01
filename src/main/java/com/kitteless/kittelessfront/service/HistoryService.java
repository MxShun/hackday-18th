package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.HistoryList;
import com.kitteless.kittelessfront.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public HistoryList getHistoryData(String userID) {
        return historyRepository.postHistory(userID);
    }
}
