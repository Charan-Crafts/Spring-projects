package com.growandshine.Quiz_Service.Controller;


import com.growandshine.Quiz_Service.DTO.CreateQuizDTO;
import com.growandshine.Quiz_Service.DTO.EvaluateQuizResponse;
import com.growandshine.Quiz_Service.DTO.QuestionResponse;
import com.growandshine.Quiz_Service.DTO.QuizResponse;
import com.growandshine.Quiz_Service.Entites.Quiz;
import com.growandshine.Quiz_Service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

//    http://localhost:8080/quiz/create?quizName=JavaQuiz&Category=Java&numQuestions=12
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody CreateQuizDTO createQuizDTO){

        return quizService.createNewQuiz(createQuizDTO.getQuizName(),createQuizDTO.getCategory(),createQuizDTO.getNumberOfQuestions());
    }

    @GetMapping("")
    public ResponseEntity<List<Quiz>> getAllQuiz(){

        return quizService.getAllQuiz();
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<List<QuestionResponse>> getQuizById(@PathVariable  Long quizId){

        return quizService.getQuizById(quizId);
    }

//    http://localhost:8080/quiz/submit/1
    @PostMapping("/submit/{quizId}")
    public ResponseEntity<Integer> evaluateQuiz(@PathVariable long quizId,@RequestBody List<EvaluateQuizResponse> evaluateQuizResponse){

        return quizService.evaluateQuiz(quizId,evaluateQuizResponse);
    }

}
