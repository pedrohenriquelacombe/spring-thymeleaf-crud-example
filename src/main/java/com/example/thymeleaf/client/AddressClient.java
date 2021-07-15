package com.example.thymeleaf.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-client", url = "https://api.postmon.com.br/v1/cep/")
public interface AddressClient {

    @GetMapping("/{cep}")
    PostmonResponse searchByCep(@PathVariable String cep);

    @Getter
    @Setter
    class PostmonResponse {
        private String cep;
        private String logradouro;
        private String bairro;
        private String cidade;
        private String estado;
    }

}
