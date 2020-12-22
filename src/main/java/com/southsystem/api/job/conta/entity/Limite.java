package com.southsystem.api.job.conta.entity;

import com.southsystem.api.job.conta.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "LIMITE")
public class Limite implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "CARTAO_CREDITO")
    private BigDecimal cartaoCredito;

    @Column(name = "CHEQUE_ESPECIAL")
    private BigDecimal chequeEspecial;

    @OneToOne
    @JoinColumn(name = "FK_CONTA_CORRENTE")
    private ContaCorrente contaCorrente;



}