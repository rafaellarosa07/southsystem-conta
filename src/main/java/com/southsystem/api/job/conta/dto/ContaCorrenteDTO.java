package com.southsystem.api.job.conta.dto;

import com.southsystem.api.job.conta.entity.Limite;
import com.southsystem.api.job.conta.entity.Pessoa;
import com.southsystem.api.job.conta.enums.TipoConta;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class ContaCorrenteDTO {

    private Long id;
    private Long numeroConta;
    private Long agencia;
    private TipoConta tipoConta;
    private Pessoa pessoa;
    private Limite limite;



}