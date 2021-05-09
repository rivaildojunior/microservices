package br.com.folha.funcionarioservice.adapter.in.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.folha.funcionarioservice.adapter.in.web.dto.input.FuncionarioInput;
import br.com.folha.funcionarioservice.adapter.in.web.dto.output.FuncionarioOutput;
import br.com.folha.funcionarioservice.adapter.in.web.mapper.FuncionarioMapper;
import br.com.folha.funcionarioservice.core.application.port.in.FuncionarioServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	
	private final FuncionarioServicePort funcionarioService;
	private final FuncionarioMapper mapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FuncionarioOutput saveFuncionario(@Valid @RequestBody FuncionarioInput input) {
		log.info("Recebendo requisição para adicionar um funcionario: " + input.getNome());

		var funcionario = this.funcionarioService.adicionar(this.mapper.toDomain(input));

		return this.mapper.toOutput(funcionario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioOutput> getFuncionarioById(@PathVariable Integer id) {
		log.info("Buscando funcionário: {}", id);

		var funcionario = this.funcionarioService.buscarPorId(id);

		return ResponseEntity.ok().body(this.mapper.toOutput(funcionario));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<FuncionarioOutput>> getAllFuncionarios() {
		log.info("Listando todos os funcionários");

		var funcionarios = this.funcionarioService.buscarTodos();

		return ResponseEntity.ok().body(this.mapper.toOutput(funcionarios));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		log.info("Excluindo funcionário: {}", id);

		this.funcionarioService.excluir(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioOutput> updateFuncionario(@PathVariable Integer id,
			@Valid @RequestBody FuncionarioInput input) {
		log.info("Recebendo requisição para atualizar funcionario {}", id);

		var funcionario = this.funcionarioService.atualizar(id, this.mapper.toDomain(input));

		return ResponseEntity.ok().body(this.mapper.toOutput(funcionario));
	}
}
