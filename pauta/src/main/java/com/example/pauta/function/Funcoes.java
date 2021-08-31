package com.example.pauta.function;

import com.example.pauta.exception.CpfException;
import com.example.pauta.model.Voto;
import com.example.pauta.service.PautaService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class Funcoes {

    private int sim;
    private int nao;
    private boolean pautaAberta;
    private String situacao;
    private List<String> cpfVotou;
    private final PautaService pautaService;

    public Funcoes(@Lazy PautaService pautaService) {
        this.pautaService = pautaService;
    }

    public void recebeStatus(String mensagem) {
        situacao = mensagem;
    }

    public String getSituacao() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return situacao;
    }

    public void timer(Long id, int tempo) {
        cpfVotou = new ArrayList<>();
        pautaAberta = true;
        int delay;
        if(tempo == 0) {
            delay = 60000;
        } else {
            delay = tempo * 60 * 1000;
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pautaAberta = false;
                cpfVotou.clear();
                pautaService.finalizarPauta(id, sim, nao);
                System.out.println("Pauta Finalizada!!!");
                timer.cancel();
            }
        }, delay);

    }

    public void computarVotacao(String cpf, Voto voto) {
        confirmarSeCpfVotou(cpf);
        if(pautaAberta == true) {
            if(voto.equals(Voto.SIM)) {
                sim++;
            }else {
                nao++;
            }
        }
    }

    private void confirmarSeCpfVotou(String cpf) {
        if(cpfVotou.contains(cpf)) {
            throw new CpfException("CPF já votou.");
        } else {
            cpfVotou.add(cpf);
        }
    }
}
