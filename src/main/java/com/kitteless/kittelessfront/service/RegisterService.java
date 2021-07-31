package com.kitteless.kittelessfront.service;

import com.kitteless.kittelessfront.data.RegisterDataResponse;
import com.kitteless.kittelessfront.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    /**
     * アカウント登録の情報をPOSTしてアカウント登録
     * @return
     */
    public boolean register(String username, String password) {
        RegisterDataResponse result = registerRepository.post(username, password);

        if (result.getResult().equals("success")) {
            return true;
        }

        return false;
    }
}
