package com.growandshine.QuizApplication.Controller;

import com.growandshine.QuizApplication.DTO.EvaluateQuizResponse;
import com.growandshine.QuizApplication.DTO.QuizResponse;
import com.growandshine.QuizApplication.Entites.Quiz;
import com.growandshine.QuizApplication.Service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestParam String quizName,@RequestParam String Category,@RequestParam long numQuestions){

        return quizService.createNewQuiz(quizName,Category,numQuestions);
    }

    @GetMapping("")
    public ResponseEntity<List<Quiz>> getAllQuiz(){

        return quizService.getAllQuiz();
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<QuizResponse> getQuizById(@PathVariable  Long quizId){

        return quizService.getQuizById(quizId);
    }

//    http://localhost:8080/quiz/submit/1
    @PostMapping("/submit/{quizId}")
    public ResponseEntity<Integer> evaluateQuiz(@PathVariable long quizId,@RequestBody List<EvaluateQuizResponse> evaluateQuizResponse){

        return quizService.evaluateQuiz(quizId,evaluateQuizResponse);
    }

}
