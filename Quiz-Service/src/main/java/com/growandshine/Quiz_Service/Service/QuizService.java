package com.growandshine.Quiz_Service.Service;


import com.growandshine.Quiz_Service.DTO.EvaluateQuizResponse;
import com.growandshine.Quiz_Service.DTO.QuestionResponse;
import com.growandshine.Quiz_Service.DTO.QuizResponse;
import com.growandshine.Quiz_Service.Entites.Quiz;
import com.growandshine.Quiz_Service.Feign.FeignInterface;
import com.growandshine.Quiz_Service.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private FeignInterface feignInterface;

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<String> createNewQuiz(String quizName, String category, long numQuestions) {


        //Create a quiz

        List<Long> questionIds = feignInterface.generateQuestions(category,numQuestions).getBody();

        Quiz newQuiz = new Quiz();

        newQuiz.setQuizName(quizName);
        newQuiz.setQuestionIds(questionIds);

        quizRepository.save(newQuiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.OK);

    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {

        List<Quiz> quizList = quizRepository.findAll();

        return new ResponseEntity<>(quizList,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionResponse>> getQuizById(Long quizId) {

        // find the quiz

        List<Long> quizIds = quizRepository.findById(quizId).get().getQuestionIds();

        List<QuestionResponse> response=feignInterface.getQuestionsByIds(quizIds).getBody();

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<Integer> evaluateQuiz(Long quizId,List<EvaluateQuizResponse> evaluateQuizResponse) {

        //find the quiz

        Quiz quiz = quizRepository.findById(quizId).orElse(null);


        if(quiz==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int score = feignInterface.getScore(evaluateQuizResponse).getBody();

        System.out.println("Final Score: " + score);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
