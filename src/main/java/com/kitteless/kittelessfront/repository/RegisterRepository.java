package com.kitteless.kittelessfront.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository {

    public String post(String username, String password) {
        // TODO: SQL で INSERT する

        return "success";
    }

}
