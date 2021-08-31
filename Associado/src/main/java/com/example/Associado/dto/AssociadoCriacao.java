package com.example.Associado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@Getter
public class AssociadoCriacao {

    private String nome;
    @CPF
    private String cpf;

}
