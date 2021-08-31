package com.example.pauta.service;

import com.example.pauta.function.Funcoes;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RecebeStatusCpf {

    private final Funcoes funcoes;

    public RecebeStatusCpf(Funcoes funcoes) {
        this.funcoes = funcoes;
    }


    @KafkaListener(topics = "envia-status-cpf")
    public void recebeStatus(String mensagem) {
        System.out.println(mensagem);
        funcoes.recebeStatus(mensagem);
    }

}
