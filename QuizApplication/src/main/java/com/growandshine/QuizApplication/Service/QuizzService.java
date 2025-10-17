package com.growandshine.QuizApplication.Service;

import com.growandshine.QuizApplication.DTO.EvaluateRequest;
import com.growandshine.QuizApplication.DTO.QuizResponse;
import com.growandshine.QuizApplication.Entites.Question;
import com.growandshine.QuizApplication.Entites.Quizz;
import com.growandshine.QuizApplication.Repository.QuestionsRepository;
import com.growandshine.QuizApplication.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizzService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<String> createQuizz(String qname, String topic, long numQ) {

        // Find the questions based on topic with number of questions

        List<Question> questionList = questionsRepository.findByQuizTopic(topic, numQ);

        // Store in quiz table

        Quizz newQuizz = new Quizz();
        newQuizz.setQuizName(topic);
        newQuizz.setQuestions(questionList);

        quizRepository.save(newQuizz);

        return new ResponseEntity<>("quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuizResponse>> getQuizByID(Long id) {

        Quizz quizz = quizRepository.findById(id).orElse(null);

       List<QuizResponse> response = quizz.getQuestions().stream()
               .map(question ->
                       QuizResponse.builder()
                               .id(question.getId())
                               .question(question.getQuestion())
                               .optionA(question.getOptionA())
                               .optionB(question.getOptionB())
                               .optionC(question.getOptionC())
                               .optionD(question.getOptionD())
                               .build()
                       )
               .toList();

        return new ResponseEntity<>(response,HttpStatus.OK);


    }

    public ResponseEntity<Integer> evaluate(long id, List<EvaluateRequest> evaluateRequests) {
        Quizz quiz = quizRepository.findById(id).orElse(null);

        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int score = 0;

        // Convert quiz questions to a map for quick lookup
        Map<Long, Question> questionMap = quiz.getQuestions()
                .stream()
                .collect(Collectors.toMap(Question::getId, q -> q));

        for (EvaluateRequest response : evaluateRequests) {
            Question question = questionMap.get(response.getId());

            if (question != null && question.getCorrectAnswer().equalsIgnoreCase(response.getResponse())) {
                score++;
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
