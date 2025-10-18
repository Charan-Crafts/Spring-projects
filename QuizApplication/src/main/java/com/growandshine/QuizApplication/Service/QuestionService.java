package com.growandshine.QuizApplication.Service;

import com.growandshine.QuizApplication.DTO.QuestionRequest;
import com.growandshine.QuizApplication.Entites.Questions;
import com.growandshine.QuizApplication.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Questions>> getAllQuestions() {

        List<Questions> getAllQuestions = questionRepository.findAll();

        return new ResponseEntity<>(getAllQuestions, HttpStatus.OK);
    }

    public ResponseEntity<List<Questions>> fetchByCategory(String category) {

        List<Questions> getQuestions = questionRepository.findByCategory(category);

        return new ResponseEntity<>(getQuestions,HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(QuestionRequest questionRequest) {

        Questions question = new Questions();
        question.setQuestion(questionRequest.getQuestion());
        question.setCategory(questionRequest.getCategory());
        question.setTopic(questionRequest.getTopic());
        question.setCorrectAnswer(questionRequest.getCorrectAnswer());
        question.setOptionA(questionRequest.getOptionA());
        question.setOptionB(questionRequest.getOptionB());
        question.setOptionC(questionRequest.getOptionC());
        question.setOptionD(questionRequest.getOptionD());
        question.setDifficultLevel(questionRequest.getDifficultLevel());

        questionRepository.save(question);

        return new ResponseEntity<>("Question added",HttpStatus.CREATED);
    }
}
