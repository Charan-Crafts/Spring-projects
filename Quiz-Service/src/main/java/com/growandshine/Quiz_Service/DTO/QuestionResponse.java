package com.growandshine.Quiz_Service.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResponse {

    private Long id;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;
}
