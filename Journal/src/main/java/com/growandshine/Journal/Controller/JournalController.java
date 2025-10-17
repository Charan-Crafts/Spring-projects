package com.growandshine.Journal.Controller;

import com.growandshine.Journal.Entites.Journal;
import com.growandshine.Journal.Service.JournalService;
import com.growandshine.Journal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping()
    public ResponseEntity<List<Journal>> getAllJournal(){

        return journalService.getAllJournals();
    }

    @PostMapping("/addJournal/{userName}")
    public ResponseEntity<String> addJournal(@RequestBody Journal journal,@PathVariable String userName){
        journal.setCreatedAt(LocalDate.now());
        return journalService.addJournal(journal,userName);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteJournal(@RequestBody String journalName){

        return journalService.deleteJournal(journalName);
    }
}

