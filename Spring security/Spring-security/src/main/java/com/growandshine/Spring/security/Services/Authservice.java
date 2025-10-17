package com.growandshine.Spring.security.Services;

import com.growandshine.Spring.security.DTO.SignupDTO;
import com.growandshine.Spring.security.Entites.Users;
import com.growandshine.Spring.security.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Authservice {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<String> signup(SignupDTO signupDTO) {

        Users newUser = new Users();
        newUser.setUserName(signupDTO.getUserName());
        newUser.setPassword(bCryptPasswordEncoder.encode(signupDTO.getPassword()));
        newUser.setRole(signupDTO.getRole()!="ADMIN"?"USER":"ADMIN");

        userRepository.save(newUser);

        return new ResponseEntity<>("User is created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Users>> getAllUsers() {

        List<Users> usersList = userRepository.findAll();

        return new ResponseEntity<>(usersList,HttpStatus.OK);
    }
}
