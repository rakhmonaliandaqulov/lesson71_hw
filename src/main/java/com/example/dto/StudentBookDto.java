package com.example.dto;

import com.example.enums.StudentBookStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class StudentBookDto {
    private Integer  id;
    private Integer studentId;
    private Integer bookId;
    private LocalDateTime createdDate;
    private StudentBookStatus status;
    private LocalDate returnedDate;
}
