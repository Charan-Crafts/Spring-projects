package com.growandshine.QuizApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {

    private String question;

    private String category;

    private String topic;

    private String correctAnswer;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String difficultLevel;
}
