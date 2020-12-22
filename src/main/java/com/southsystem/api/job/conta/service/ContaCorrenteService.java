package com.southsystem.api.job.conta.service;

import com.southsystem.api.job.conta.dto.ContaCorrenteDTO;
import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.entity.Pessoa;
import com.southsystem.api.job.conta.enums.TipoConta;
import com.southsystem.api.job.conta.enums.TipoPessoaEnum;
import com.southsystem.api.job.conta.repository.ContaCorrenteRepository;
import com.southsystem.api.job.conta.repository.ContaCorrenteRepository;
import com.southsystem.api.job.conta.repository.LimiteRepository;
import com.southsystem.api.job.conta.repository.PessoaRepository;
import com.southsystem.api.job.conta.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Random;

@Service
public class ContaCorrenteService {

    @Value("${propriedade.agencia}")
    private Long agencia;

    @Autowired
    private PessoaRepository pessoaRepository;

    private LimiteRepository limiteRepository;


    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    private Mensagem mensagem;



    public ResponseEntity<List<ContaCorrente>> listarTodos() {

        List<ContaCorrente> contaCorrentes = contaCorrenteRepository.findAll();
        if (ObjectUtils.isEmpty(contaCorrentes)) {
            return new ResponseEntity<List<ContaCorrente>>(contaCorrentes, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ContaCorrente>>(contaCorrentes, HttpStatus.OK);

    }

    public ResponseEntity<ContaCorrente> listarPorId(Long id) {
        ContaCorrente retorna = contaCorrenteRepository.findOne(id);
        if (ObjectUtils.isEmpty(retorna)) {
        }
        return new ResponseEntity<ContaCorrente>(retorna, HttpStatus.OK);
    }


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
