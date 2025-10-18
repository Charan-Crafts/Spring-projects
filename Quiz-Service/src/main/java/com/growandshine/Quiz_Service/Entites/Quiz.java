package com.growandshine.Quiz_Service.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quizId;

    private String quizName;

    @ElementCollection
    private List<Long> questionIds;

}
