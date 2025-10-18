package com.growandshine.QuizApplication.Service;

import com.growandshine.QuizApplication.DTO.EvaluateQuizResponse;
import com.growandshine.QuizApplication.DTO.QuestionResponse;
import com.growandshine.QuizApplication.DTO.QuizResponse;
import com.growandshine.QuizApplication.Entites.Questions;
import com.growandshine.QuizApplication.Entites.Quiz;
import com.growandshine.QuizApplication.Repository.QuestionRepository;
import com.growandshine.QuizApplication.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<String> createNewQuiz(String quizName, String category, long numQuestions) {

        //Get all the questions based upon the category;
        List<Questions> getRandomQuestions = questionRepository.randomQuestions(category,numQuestions);

        //Create a quiz

        Quiz newQuiz = new Quiz();

        newQuiz.setQuizName(quizName);
        newQuiz.setQuestionsList(getRandomQuestions);

        quizRepository.save(newQuiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.OK);

    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {

        List<Quiz> quizList = quizRepository.findAll();

        return new ResponseEntity<>(quizList,HttpStatus.OK);
    }

    public ResponseEntity<QuizResponse> getQuizById(Long quizId) {

        // find the quiz

        Quiz quiz = quizRepository.findById(quizId).orElse(null);

        if(quiz==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        QuizResponse quizResponse = QuizResponse.builder()
                .quizId(quiz.getQuizId())
                .quizName(quiz.getQuizName())
                .questionResponse(

                        quiz.getQuestionsList().stream()
                                .map(q-> QuestionResponse.builder()
                                        .id(q.getId())
                                        .question(q.getQuestion())
                                        .optionA(q.getOptionA())
                                        .optionB(q.getOptionB())
                                        .optionC(q.getOptionC())
                                        .optionD(q.getOptionD())
                                        .build())
                                .toList()
                )
                .build();
        return new ResponseEntity<>(quizResponse,HttpStatus.OK);
    }

    public ResponseEntity<Integer> evaluateQuiz(Long quizId,List<EvaluateQuizResponse> evaluateQuizResponse) {

        //find the quiz

        Quiz quiz = quizRepository.findById(quizId).orElse(null);


        if(quiz==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int score = 0;

        for (EvaluateQuizResponse response : evaluateQuizResponse) {
            for (Questions question : quiz.getQuestionsList()) {
                if (question.getId()==(response.getQuestionId())) {
                    System.out.println("Question ID: " + question.getId());
                    System.out.println("User Answer: '" + response.getAnswer() + "'");
                    System.out.println("Correct Answer: '" + question.getCorrectAnswer() + "'");

                    if (question.getCorrectAnswer() != null &&
                            response.getAnswer() != null &&
                            question.getCorrectAnswer().trim().equalsIgnoreCase(response.getAnswer().trim())) {
                        score++;
                        System.out.println("✓ CORRECT");
                    } else {
                        System.out.println("✗ INCORRECT");
                    }
                    System.out.println("---");
                    break;
                }
            }
        }

        System.out.println("Final Score: " + score);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
