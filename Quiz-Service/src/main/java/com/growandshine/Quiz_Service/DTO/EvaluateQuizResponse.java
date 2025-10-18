package com.growandshine.Quiz_Service.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EvaluateQuizResponse {

    private Long questionId;

    private String answer;
}
