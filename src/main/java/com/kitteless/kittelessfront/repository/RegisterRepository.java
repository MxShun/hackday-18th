package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.RegisterData;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RegisterRepository {

    private RestTemplate restTemplate;

    public String post(String username, String password) {
        RegisterData registerData = restTemplate.getForObject("hoge", RegisterData.class);

        // return registerData.getResult();
        return "success";
    }

}
