package com.southsystem.api.job.conta.schedule;

import com.southsystem.api.job.conta.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CriarConta {

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @Scheduled(cron = "0 0/1 * * * *")
    public void verificarPessoaCriarConta() {
        contaCorrenteService.criarConta();
    }

}