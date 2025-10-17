package com.growandshine.Journal.Service;

import com.growandshine.Journal.Entites.User;
import com.growandshine.Journal.Repo.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> getAllUser() {

        List<User> getAllusers = userRepository.findAll();

        if(getAllusers.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(getAllusers,HttpStatus.OK);
    }

    public ResponseEntity<String> addUser(User user) {

        // Check the user is already exists with the username or not

        Optional<User> isUser = userRepository.findByUserName(user.getUserName());

        if(isUser.isPresent()){

            return new ResponseEntity<>("User already Exists with this name",HttpStatus.BAD_REQUEST);
        }

        userRepository.save(user);

        return new ResponseEntity<>("User is added",HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUserByName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
