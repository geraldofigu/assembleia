package com.example.pauta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TB_PAUTA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private LocalDate dataAbertura;
    @Column
    private LocalTime horaInicio;
    @Column
    private LocalTime horaFim;
    @Column
    private BigDecimal concordam;
    @Column
    private BigDecimal naoConcordam;

}
