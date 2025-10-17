package com.growandshine.TODO.application.Entites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class Tasks {

    @Id
    private String id;

    private String taskName;

    private String status;

    private LocalDate deadLine;

}
