package com.growandshine.TODO.application.DTO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private String taskName;

    private LocalDate deadline;

}
