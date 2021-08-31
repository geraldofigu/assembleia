package com.example.Associado.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsultaCpfService {

    private final AssociadoService associadoService;

    public ConsultaCpfService(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @KafkaListener(topics = "solicita-status-cpf")
    public void coletarCpf(String cpf) {
        associadoService.buscarSituacaoCpf(cpf);
    }

}
