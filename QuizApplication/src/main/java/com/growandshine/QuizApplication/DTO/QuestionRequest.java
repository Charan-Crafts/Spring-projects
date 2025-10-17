package com.growandshine.QuizApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String difficultyLevel;

    private String topic;

    private String correctAnswer;
}
