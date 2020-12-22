package com.southsystem.api.job.conta.controller;

import com.southsystem.api.job.conta.dto.ContaCorrenteDTO;
import com.southsystem.api.job.conta.entity.ContaCorrente;
import com.southsystem.api.job.conta.service.ContaCorrenteService;
import com.southsystem.api.job.conta.util.Mensagem;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/contaCorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;



	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar ContaCorrente", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Execução realizada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<List<ContaCorrente>> listarContaCorrente() {
		return contaCorrenteService.listarTodos();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retorna ContaCorrente por Id", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Identificador único da ContaCorrente que será consultado.", required = true, dataType = "Integer", paramType = "path") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Execução realizada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<ContaCorrente> buscaContaCorrenteoById(@PathVariable Long id) {
		return contaCorrenteService.listarPorId(id);
	}

}
