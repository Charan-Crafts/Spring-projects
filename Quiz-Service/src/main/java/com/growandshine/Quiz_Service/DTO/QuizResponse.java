package com.growandshine.Quiz_Service.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizResponse {

    private Long quizId;

    private String quizName;

    private List<QuestionResponse> questionResponse;

}
