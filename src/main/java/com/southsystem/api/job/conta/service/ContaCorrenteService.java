package com.southsystem.api.job.conta.service;

import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.entity.Pessoa;
import com.southsystem.api.job.conta.enums.TipoConta;
import com.southsystem.api.job.conta.enums.TipoPessoaEnum;
import com.southsystem.api.job.conta.repository.ContaCorrenteRepository;
import com.southsystem.api.job.conta.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaCorrenteService {

    @Value("${propriedade.agencia}")
    private Long agencia;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    public void criarConta(){
        List<Pessoa> pessoasNaoPossuiConta = pessoaRepository.findPessoasNaoPossuiConta();
        for (Pessoa pessoa : pessoasNaoPossuiConta) {
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setAgencia(agencia);
            contaCorrente.setPessoa(pessoa);
            contaCorrente.setTipoConta(pessoa.getTipoPessoa().equals(TipoPessoaEnum.PJ) ? TipoConta.E : TipoConta.C);
            contaCorrenteRepository.save(contaCorrente);
        }
    }

}
