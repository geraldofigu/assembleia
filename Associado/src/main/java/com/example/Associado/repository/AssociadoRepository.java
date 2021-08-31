package com.example.Associado.repository;

import com.example.Associado.model.Associado;
import com.example.Associado.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Associado findByCpf(String cpf);
}
