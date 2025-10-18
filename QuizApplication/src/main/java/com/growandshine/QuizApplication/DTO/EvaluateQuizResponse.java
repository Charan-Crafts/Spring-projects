package com.growandshine.QuizApplication.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EvaluateQuizResponse {

    private Long questionId;

    private String answer;
}
