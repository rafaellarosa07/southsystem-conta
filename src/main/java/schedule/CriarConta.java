package schedule;

import com.southsystem.api.job.conta.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CriarConta {

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @Scheduled(cron = "0 0/1 * * * *")
    public void verificarPessoaCriarConta() {
        contaCorrenteService.criarConta();
    }

}