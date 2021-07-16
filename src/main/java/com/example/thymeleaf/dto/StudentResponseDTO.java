package com.example.thymeleaf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponseDTO {

    private String id;
    private String name;
    private String email;
    private LocalDate birthday;

    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;

    private LocalDateTime createdAt;

    @JsonProperty(value = "age")
    public Integer getAge() {
        if (ObjectUtils.isEmpty(this.birthday)) {
            return null;
        }
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

}
