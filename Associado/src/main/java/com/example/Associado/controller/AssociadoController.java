package com.example.Associado.controller;

import com.example.Associado.dto.AssociadoCriacao;
import com.example.Associado.service.AssociadoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/associado")
@Api(tags = "Associado", description = "Controller para Gestão de Associado")
public class AssociadoController {

    private final AssociadoService associadoService;

    public AssociadoController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @PostMapping
    public void criar(@RequestBody @Valid AssociadoCriacao criacao) {
        associadoService.criar(criacao);
    }


}
