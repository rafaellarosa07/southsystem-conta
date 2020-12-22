package com.southsystem.api.job.conta.service;

import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.entity.Limite;
import com.southsystem.api.job.conta.entity.Pessoa;
import com.southsystem.api.job.conta.repository.ContaCorrenteRepository;
import com.southsystem.api.job.conta.repository.LimiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LimiteService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private LimiteRepository limiteRepository;

    public void criarLimites(){
        List<ContaCorrente> contaCorrenteNaoPossuiLimite = contaCorrenteRepository.findContaCorrenteNaoPossuiLimite();

        for(ContaCorrente conta : contaCorrenteNaoPossuiLimite){
            Limite limite = new Limite();
            this.verificarScore(conta.getPessoa(),limite);
            limite.setContaCorrente(conta);
            limiteRepository.save(limite);
        }

    }


    private Limite verificarScore(Pessoa pessoa,Limite limite){
        if(pessoa.getScore() >= 2 &&  pessoa.getScore() <= 5){
            limite.setCartaoCredito(new BigDecimal(200));
            limite.setChequeEspecial(new BigDecimal(1000));
        }
        if(pessoa.getScore() >= 6 &&  pessoa.getScore() <= 8){
            limite.setCartaoCredito(new BigDecimal(2000));
            limite.setChequeEspecial(new BigDecimal(2000));
        }
        if(pessoa.getScore() == 9){
            limite.setCartaoCredito(new BigDecimal(15000));
            limite.setChequeEspecial(new BigDecimal(5000));
        }
        else{
            limite.setCartaoCredito(new BigDecimal(0));
            limite.setChequeEspecial(new BigDecimal(0));
        }

        return limite;
    }

}
