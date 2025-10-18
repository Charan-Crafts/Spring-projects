package com.growandshine.QuizApplication.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
