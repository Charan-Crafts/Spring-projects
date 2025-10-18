package com.growandshine.QuizApplication.Controller;


import com.growandshine.QuizApplication.DTO.QuestionRequest;
import com.growandshine.QuizApplication.Entites.Questions;
import com.growandshine.QuizApplication.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("Appliation is running", HttpStatus.OK);
    }

    @GetMapping("/allquestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Questions>> fetchByCategory(@PathVariable String category){

        return questionService.fetchByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewQuestion(@RequestBody QuestionRequest questionRequest){

        return questionService.addQuestion(questionRequest);
    }
}
