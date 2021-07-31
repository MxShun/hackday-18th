package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.LoginResponse;
import com.kitteless.kittelessfront.data.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class LoginRepository {

    public LoginResponse post(String username, String password) {
        User user = new User();
        user.setId("");
        user.setName(username);
        user.setPassword(password);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://localhost:1123/login", user, LoginResponse.class);
    }

}
