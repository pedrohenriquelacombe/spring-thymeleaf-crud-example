package com.example.thymeleaf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponseDTO {

    private String street;
    private String district;
    private String city;
    private String state;

}
