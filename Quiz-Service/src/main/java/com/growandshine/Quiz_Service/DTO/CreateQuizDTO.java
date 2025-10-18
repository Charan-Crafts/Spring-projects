package com.growandshine.Quiz_Service.DTO;

import lombok.Data;

@Data
public class CreateQuizDTO {

    private String quizName;

    private String category;

    private long numberOfQuestions;
}
