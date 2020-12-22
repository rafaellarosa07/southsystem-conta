package com.southsystem.api.job.conta.repository;

import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "select p from Pessoa p where p.id " +
            "not in (SELECT c.pessoa.id from ContaCorrente c)")
    List<Pessoa> findPessoasNaoPossuiConta();

}
