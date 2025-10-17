package com.growandshine.QuizApplication.Service;

import com.growandshine.QuizApplication.DTO.QuestionRequest;
import com.growandshine.QuizApplication.DTO.QuestionResponse;
import com.growandshine.QuizApplication.Entites.Question;
import com.growandshine.QuizApplication.Repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;

    public List<QuestionResponse> getAllQuestions() {

        List<Question> allQuestions = questionsRepository.findAll();

        return allQuestions.stream().map(question ->
                QuestionResponse.builder()
                        .id(question.getId())
                        .question(question.getQuestion())
                        .optionA(question.getOptionA())
                        .optionB(question.getOptionB())
                        .optionC(question.getOptionC())
                        .optionD(question.getOptionD())
                        .difficultyLevel(question.getDifficultyLevel())
                        .topic(question.getTopic())
                        .build()
                )
                .toList();

    }

    public List<QuestionResponse> fetchBasedUponCategory(String category) {

        List<Question> allQuestions = questionsRepository.findByTopic(category).orElse(null);

        return allQuestions.stream().map(question ->
                        QuestionResponse.builder()
                                .id(question.getId())
                                .question(question.getQuestion())
                                .optionA(question.getOptionA())
                                .optionB(question.getOptionB())
                                .optionC(question.getOptionC())
                                .optionD(question.getOptionD())
                                .difficultyLevel(question.getDifficultyLevel())
                                .topic(question.getTopic())
                                .build()
                )
                .toList();
    }

    public String addQuestion(QuestionRequest questionRequest) {

        Question q = Question.builder()
                .question(questionRequest.getQuestion())
                .optionA(questionRequest.getOptionA())
                .optionB(questionRequest.getOptionB())
                .optionC(questionRequest.getOptionC())
                .optionD(questionRequest.getOptionD())
                .topic(questionRequest.getTopic())
                .difficultyLevel(questionRequest.getDifficultyLevel())
                .correctAnswer(questionRequest.getCorrectAnswer())
                .build();

        questionsRepository.save(q);
        return ("Question added !");
    }

    public String updateQuestion(QuestionRequest questionRequest, Long id) {
        Question question = questionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with ID: " + id));

        if (questionRequest.getQuestion() != null && !questionRequest.getQuestion().isBlank()) {
            question.setQuestion(questionRequest.getQuestion());
        }

        if (questionRequest.getCorrectAnswer() != null && !questionRequest.getCorrectAnswer().isBlank()) {
            question.setCorrectAnswer(questionRequest.getCorrectAnswer());
        }

        if (questionRequest.getOptionA() != null && !questionRequest.getOptionA().isBlank()) {
            question.setOptionA(questionRequest.getOptionA());
        }

        if (questionRequest.getOptionB() != null && !questionRequest.getOptionB().isBlank()) {
            question.setOptionB(questionRequest.getOptionB());
        }

        if (questionRequest.getOptionC() != null && !questionRequest.getOptionC().isBlank()) {
            question.setOptionC(questionRequest.getOptionC());
        }

        if (questionRequest.getOptionD() != null && !questionRequest.getOptionD().isBlank()) {
            question.setOptionD(questionRequest.getOptionD());
        }

        if (questionRequest.getTopic() != null && !questionRequest.getTopic().isBlank()) {
            question.setTopic(questionRequest.getTopic());
        }

        if (questionRequest.getDifficultyLevel() != null && !questionRequest.getDifficultyLevel().isBlank()) {
            question.setDifficultyLevel(questionRequest.getDifficultyLevel());
        }

        questionsRepository.save(question);

        return "Question updated";
    }

    public String deleteQuestion(long id) {

        Question q = questionsRepository.findById(id).orElse(null);

        questionsRepository.deleteById(id);

        return "Deleted";
    }
}
