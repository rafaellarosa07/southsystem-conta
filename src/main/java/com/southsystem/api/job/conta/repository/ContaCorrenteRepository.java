package com.southsystem.api.job.conta.repository;

import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    @Query(value = "select c from ContaCorrente c where c.id " +
            "not in (SELECT l.contaCorrente.id from Limite l)")
    List<ContaCorrente> findContaCorrenteNaoPossuiLimite();
}
