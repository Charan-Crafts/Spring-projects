package com.mongo.Data.Migration.MongoMigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRep userRep;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRep.findAll();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userRep.save(user);
        return "User is added";
    }
}
