package com.growandshine.TODO.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class TaskResponse {

    private String id;

    private String taskName;

    private String status;

    private LocalDate deadLine;

}
