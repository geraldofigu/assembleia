package com.example.pauta.dto;

import lombok.Getter;

@Getter
public class AberturaDados {

    private Long id;
    private Integer tempoDuracao;

    public AberturaDados(Long id, Integer tempoDuracao) {
        this.id = id;
        this.tempoDuracao = tempoDuracao != null ? tempoDuracao : 0;
    }
}
