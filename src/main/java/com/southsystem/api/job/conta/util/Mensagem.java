package com.southsystem.api.job.conta.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {

    private String msg;
    private Long id;
    // warn - Aviso, success - Sucesso, error - Erro, info - Info
    private String tipo;
    private boolean sts;

}
