package com.example.Associado.service;

import com.example.Associado.client.VerificaCpf;
import com.example.Associado.dto.AssociadoCriacao;
import com.example.Associado.exception.ConnectionException;
import com.example.Associado.model.Associado;
import com.example.Associado.model.Situacao;
import com.example.Associado.repository.AssociadoRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {

    private final AssociadoRepository associadoRepository;
    private final VerificaCpf verificaCpf;
    private final ServicoMensagem servicoMensagem;

    public AssociadoService(AssociadoRepository associadoRepository, VerificaCpf verificaCpf, ServicoMensagem servicoMensagem) {
        this.associadoRepository = associadoRepository;
        this.verificaCpf = verificaCpf;
        this.servicoMensagem = servicoMensagem;
    }

    public Long criar(AssociadoCriacao criacao) {
        Situacao situacao = verificaSituacao(criacao.getCpf());
        Associado associado = new Associado(null, criacao.getNome(), criacao.getCpf(), situacao);
        Associado associadoSalvo = associadoRepository.save(associado);
        return associadoSalvo.getId();
    }

    private Situacao verificaSituacao(String cpf) {
        String status;
        try {
            status = verificaCpf.getDados(cpf).getSituacao();
        } catch (RuntimeException e) {
            throw new ConnectionException("Servidor não disponível.");
        }
        if(status.equalsIgnoreCase(Situacao.ABLE_TO_VOTE.toString())) {
            return Situacao.ABLE_TO_VOTE;
        } else {
            return Situacao.UNABLE_TO_VOTE;
        }
    }

    public void buscarSituacaoCpf(String cpf) {
        Associado associado = associadoRepository.findByCpf(cpf);
        String situacao = associado.getSituacao().toString();
        servicoMensagem.enviarStatusCpf(situacao);
    }
}
