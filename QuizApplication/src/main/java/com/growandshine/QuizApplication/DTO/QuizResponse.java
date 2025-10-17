package com.growandshine.QuizApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizResponse {

    private Long id;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

}
