package com.growandshine.Journal.Service;

import com.growandshine.Journal.Entites.Journal;
import com.growandshine.Journal.Entites.User;
import com.growandshine.Journal.Repo.JournalRepository;
import com.growandshine.Journal.Repo.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<Journal>> getAllJournals() {

        List<Journal> journalEntries = journalRepository.findAll();

        if(journalEntries.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(journalEntries,HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<String> addJournal(Journal journal,String userName) {

        Journal savedJournal = journalRepository.save(journal);

        // Find that particular person

        Optional<User> user = userRepository.findByUserName(userName);

        if(user.isPresent()){
            User getUser = user.get();
            getUser.getJournalEntries().add(savedJournal);
            userRepository.save(getUser);
            return new ResponseEntity<>("Journal is added",HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> deleteJournal(String journalName) {

        // Delete it from User


        return new ResponseEntity<>("null",HttpStatus.FOUND);

    }
}
