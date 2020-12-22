package com.southsystem.api.job.conta.repository;

import com.southsystem.api.job.conta.entity.Limite;
import com.southsystem.api.job.conta.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LimiteRepository extends JpaRepository<Limite, Long> {


}
