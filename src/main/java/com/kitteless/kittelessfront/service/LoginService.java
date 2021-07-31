package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public boolean login(String username, String password) {
        String result = loginRepository.post("usernane", "passord");

        // if (result.equals("success")) {
        //     return true;
        // }
        //
        // return false;

        return true;
    }
}
