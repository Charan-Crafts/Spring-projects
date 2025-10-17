package com.growandshine.QuizApplication.Controller;


import com.growandshine.QuizApplication.DTO.EvaluateRequest;
import com.growandshine.QuizApplication.DTO.QuizResponse;
import com.growandshine.QuizApplication.Entites.Quizz;
import com.growandshine.QuizApplication.Service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizz")
public class QuizzController {

    @Autowired
    private QuizzService quizzService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuizz(@RequestParam String qname,@RequestParam String topic ,@RequestParam long numQ){

//        return new ResponseEntity<>("Okay ", HttpStatus.CREATED);

        return quizzService.createQuizz(qname,topic,numQ);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<List<QuizResponse>> getQuizById(@PathVariable Long id){
        return quizzService.getQuizByID(id);
    }

    @PostMapping("/evaluate/{id}")
    public ResponseEntity<Integer> evaluate(@PathVariable long id, @RequestBody List<EvaluateRequest> evaluateRequests){

        return quizzService.evaluate(id,evaluateRequests);
    }
}
