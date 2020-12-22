package com.southsystem.api.job.conta.entity;

import com.southsystem.api.job.conta.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CONTA_CORRENTE")
public class ContaCorrente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NUMERO", unique = true)
    private Long numeroConta;

    @Column(name = "AGENCIA")
    private Long agencia;

    @Column(name = "TP_CONTA")
    private TipoConta tipoConta;

    @OneToOne
    @JoinColumn(name = "FK_PESSOA")
    private Pessoa pessoa;



}