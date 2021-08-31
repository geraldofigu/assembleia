package com.example.Associado.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "verifica-cpf", url = "localhost:3001")
public interface VerificaCpf {

    @GetMapping("/statuscpf/{cpf}")
    SituacaoCpfDto getDados(@PathVariable("cpf") String cpf);

}
