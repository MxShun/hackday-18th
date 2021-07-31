package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public boolean entry(String stampCode, String image) {
        String result = entryRepository.post("stampCode", "image");

        if (result.equals("success")) {
            return true;
        }

        return false;
    }
}
