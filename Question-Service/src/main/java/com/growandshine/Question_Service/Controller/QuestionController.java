package com.growandshine.Question_Service.Controller;


import com.growandshine.Question_Service.DTO.EvaluateQuizResponse;
import com.growandshine.Question_Service.DTO.QuestionRequest;
import com.growandshine.Question_Service.DTO.QuestionResponse;
import com.growandshine.Question_Service.Entites.Questions;
import com.growandshine.Question_Service.Service.QuestionService;
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

    @GetMapping("/generate")
    public ResponseEntity<List<Long>> generateQuestions(@RequestParam String category,@RequestParam long numberofquestions){
        return questionService.generateQuestionsForQuiz(category,numberofquestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByIds(@RequestBody List<Long> questionIds){

        return questionService.getQuestionsByIds(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<EvaluateQuizResponse> evaluateQuizResponse){

        return questionService.calculateScore(evaluateQuizResponse);
    }
}
