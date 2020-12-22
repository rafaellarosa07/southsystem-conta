package com.southsystem.api.job.conta.schedule;

import com.southsystem.api.job.conta.service.LimiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CriarLimite {

    @Autowired
    private LimiteService limiteService;

    @Scheduled(cron = "0 0/1 * * * *")
    public void criarLimite() {
        limiteService.criarLimites();
    }

}