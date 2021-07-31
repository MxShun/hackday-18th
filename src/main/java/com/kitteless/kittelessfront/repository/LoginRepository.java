package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.LoginData;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class LoginRepository {

    private RestTemplate restTemplate;

    public String post(String username, String password) {
        LoginData loginData = restTemplate.getForObject("loginAPI", LoginData.class);

        return "success";
    }
}
