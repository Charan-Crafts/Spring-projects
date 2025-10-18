package com.growandshine.Question_Service.Service;


import com.growandshine.Question_Service.DTO.EvaluateQuizResponse;
import com.growandshine.Question_Service.DTO.QuestionRequest;
import com.growandshine.Question_Service.DTO.QuestionResponse;
import com.growandshine.Question_Service.Entites.Questions;
import com.growandshine.Question_Service.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    Environment environment;

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

    public ResponseEntity<List<Long>> generateQuestionsForQuiz(String category, long numberOfquestions) {

        List<Long> questionIds = questionRepository.randomQuestions(category,numberOfquestions);

        return new ResponseEntity<>(questionIds,HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionResponse>> getQuestionsByIds(List<Long> questionIds) {

        List<Questions> getAllQuestions = new ArrayList<>();

        for(Long id : questionIds){
            getAllQuestions.add(questionRepository.findById(id).get());
        }

        List<QuestionResponse> response = getAllQuestions.stream()
                .map(q->
                        QuestionResponse.builder()
                                .id(q.getId())
                                .question(q.getQuestion())
                                .optionA(q.getOptionA())
                                .optionB(q.getOptionB())
                                .optionC(q.getOptionC())
                                .optionD(q.getOptionD())
                                .build()
                        ).toList();

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateScore(List<EvaluateQuizResponse> evaluateQuizResponse) {

        int score = 0;

        for(EvaluateQuizResponse resposne:evaluateQuizResponse){
            Questions question = questionRepository.findById(resposne.getQuestionId()).get();
            if(question.getCorrectAnswer().equals(resposne.getAnswer())){
                score++;
            }
        }

        System.out.println(environment.getProperty("local.server.port"));

        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
