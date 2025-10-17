package com.growandshine.Journal.Controller;

import com.growandshine.Journal.Entites.User;
import com.growandshine.Journal.Service.EmailService;
import com.growandshine.Journal.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){

        return userService.getAllUser();
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){

        return userService.addUser(user);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName){
        return userService.getUserByName(userName);
    }

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody Map<String, String> request) {
        String to = request.get("to");
        String subject = request.get("subject");
        String body = request.get("body");

        return emailService.sendEmail(to, subject, body);
    }
}
