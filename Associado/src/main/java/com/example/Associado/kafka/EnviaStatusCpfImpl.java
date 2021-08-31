package com.example.Associado.kafka;

import com.example.Associado.service.ServicoMensagem;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviaStatusCpfImpl implements ServicoMensagem {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EnviaStatusCpfImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void enviarStatusCpf(String situacao) {
        kafkaTemplate.send("envia-status-cpf", situacao);
    }
}
