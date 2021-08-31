package com.example.pauta.controller;

import com.example.pauta.dto.AberturaDados;
import com.example.pauta.dto.PautaConsulta;
import com.example.pauta.dto.PautaCriacao;
import com.example.pauta.dto.VotacaoDados;
import com.example.pauta.service.PautaService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
@Api(tags = "Pauta", description = "Controller para Gestão de Pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @GetMapping("/{id}")
    public PautaConsulta listar(@PathVariable("id") Long id) {
        return pautaService.listar(id);
    }

    @PostMapping
    public void criar(@RequestBody PautaCriacao criacao) {
        pautaService.criar(criacao);
    }

    @PostMapping("/abrirVotacao")
    public void abrirVotacao(@RequestBody AberturaDados dados) {
        pautaService.abrirVotacao(dados);
    }

    @PostMapping("/votacao")
    public void votar(@RequestBody VotacaoDados dados) {
        pautaService.votar(dados);
    }

}
