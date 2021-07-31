package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.EntryData;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EntryRepository {

    private RestTemplate restTempleate;

    public String post(String stampCode, String image) {
        EntryData entryData = restTempleate.getForObject("API", EntryData.class);

        return "success";
    }
}
