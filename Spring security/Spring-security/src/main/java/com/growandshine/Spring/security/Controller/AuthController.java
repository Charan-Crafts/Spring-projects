package com.growandshine.Spring.security.Controller;


import com.growandshine.Spring.security.DTO.SignupDTO;
import com.growandshine.Spring.security.Entites.Users;
import com.growandshine.Spring.security.Services.Authservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private Authservice authservice;

    @GetMapping("/user")
    public String getUser(){
        return "Hello user";
    }

    @GetMapping("/password")
    public String getPassword(){
        return "This is my password";
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDTO signupDTO){

        return authservice.signup(signupDTO);
    }



    @GetMapping("/auth")
    public ResponseEntity<List<Users>> getAllUsers(){

        return authservice.getAllUsers();
    }
}
