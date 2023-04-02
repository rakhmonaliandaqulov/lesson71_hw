package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Integer id;
    private String title;
    private String author;
    private String publishYear;
    private Integer amount;
    private Boolean visible;
}
