package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private String psw;
    private String phone;
    private LocalDate createdDate;
    private Boolean visible;

}
