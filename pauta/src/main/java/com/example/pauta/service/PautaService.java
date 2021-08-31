package com.example.pauta.service;

import com.example.pauta.dto.AberturaDados;
import com.example.pauta.dto.PautaConsulta;
import com.example.pauta.dto.PautaCriacao;
import com.example.pauta.dto.VotacaoDados;
import com.example.pauta.exception.CpfException;
import com.example.pauta.function.Funcoes;
import com.example.pauta.model.Pauta;
import com.example.pauta.repository.PautaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;
    private final Funcoes funcoes;
    private final ServicoMensagem servicoMensagem;
    private final RecebeStatusCpf recebeStatusCpf;

    public PautaService(PautaRepository pautaRepository, Funcoes funcoes, ServicoMensagem servicoMensagem, RecebeStatusCpf recebeStatusCpf) {
        this.pautaRepository = pautaRepository;
        this.funcoes = funcoes;
        this.servicoMensagem = servicoMensagem;
        this.recebeStatusCpf = recebeStatusCpf;
    }

    //listar
    public PautaConsulta listar(Long id) {
        Pauta pauta = pautaRepository.findById(id).get();
        PautaConsulta pautaConsulta =
                new PautaConsulta(pauta.getNome(), pauta.getConcordam(), pauta.getNaoConcordam());
        return pautaConsulta;
    }

    //criar
    public Long criar(PautaCriacao criacao) {
        Pauta pauta = new Pauta(null, criacao.getNome(), criacao.getDescricao(),
                LocalDate.now(), null, null, null, null);
        Pauta pautaSalva = pautaRepository.save(pauta);
        return pautaSalva.getId();
    }

    //abrirVotacao
    public void abrirVotacao(AberturaDados dados) {
        Pauta pauta = pautaRepository.getById(dados.getId());
        pauta.setHoraInicio(LocalTime.now());
        pautaRepository.save(pauta);
        funcoes.timer(dados.getId(), dados.getTempoDuracao());
    }

    //votar
    public void votar(VotacaoDados dados) {
        servicoMensagem.consutarStatusCpf(dados.getCpf());
        String situacao = funcoes.getSituacao();
        if(situacao.equalsIgnoreCase("UNABLE_TO_VOTE")) {
            throw new CpfException("Cpf não autorizado a votar votar");
        }
        funcoes.computarVotacao(dados.getCpf(), dados.getVoto());
    }

    public void finalizarPauta(Long id, int sim, int nao) {
        Pauta pauta = pautaRepository.findById(id).get();
        pauta.setHoraFim(LocalTime.now());
        pauta.setConcordam(BigDecimal.valueOf(sim));
        pauta.setNaoConcordam(BigDecimal.valueOf(nao));
        pautaRepository.save(pauta);
    }

}
