package com.example.thymeleaf.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class StudentRequestDTO {

    private String name;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

}
