package com.example.pauta.kafka;

import com.example.pauta.service.ServicoMensagem;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoStatusCpfImpl implements ServicoMensagem {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SolicitacaoStatusCpfImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void consutarStatusCpf(String cpf) {
        kafkaTemplate.send("solicita-status-cpf", cpf);
    }
}
