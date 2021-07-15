package com.example.thymeleaf.dto.mapper;

import com.example.thymeleaf.dto.AddressRequestDTO;
import com.example.thymeleaf.entity.Address;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressMapper {

    public static Address toEntity(AddressRequestDTO dto) {
        Address address = new Address();
        address.setZipCode(dto.getZipCode());
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setComplement(dto.getComplement());
        address.setDistrict(dto.getDistrict());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        return address;
    }

}
