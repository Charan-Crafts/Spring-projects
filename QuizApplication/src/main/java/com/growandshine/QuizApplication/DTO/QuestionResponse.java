package com.growandshine.QuizApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {

    private long id;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String difficultyLevel;

    private String topic;
}
