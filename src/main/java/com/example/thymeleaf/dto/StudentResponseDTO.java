package com.example.thymeleaf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private LocalDateTime createdAt;

    private AddressResponseDTO address;

    public Integer getAge() {
        if (ObjectUtils.isEmpty(this.birthday)) {
            return null;
        }
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

}
