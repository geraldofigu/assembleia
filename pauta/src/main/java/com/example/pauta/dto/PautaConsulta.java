package com.example.pauta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class PautaConsulta {

    private String nome;
    private BigDecimal concordam;
    private BigDecimal naoConcordam;

}
