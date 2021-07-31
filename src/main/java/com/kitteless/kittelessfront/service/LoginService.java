package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.LoginResponse;
import com.kitteless.kittelessfront.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    /**
     * ログインを行い、ログインが成功すると userId を return, ログイン失敗すると null を return
     * @param username
     * @param password
     * @return
     */
    public String login(String username, String password) {
        LoginResponse result = loginRepository.post(username, password);

         if (result.getUserId() != null) {
             return result.getUserId();
         }
         return null;
    }
}
