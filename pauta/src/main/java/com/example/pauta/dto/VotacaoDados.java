package com.example.pauta.dto;

import com.example.pauta.model.Voto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VotacaoDados {

    private String cpf;
    private Voto voto;

}
