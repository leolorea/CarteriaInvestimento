package br.com.bootcamp.carteira.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.bootcamp.carteira.dto.TransacaoDto;
import br.com.bootcamp.carteira.dto.TransacaoFormDto;
import br.com.bootcamp.carteira.service.ServiceTransacoes;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	@Autowired
	private ServiceTransacoes service;

	@GetMapping

	public Page<TransacaoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.listaTransacoes(paginacao);

	}

	@PostMapping
	public ResponseEntity<TransacaoDto> cadastrar(@RequestBody @Valid TransacaoFormDto dto, UriComponentsBuilder uriComponentsBuilder) {
		TransacaoDto transacaoDto = service.cadastrar(dto);
		
		java.net.URI uri = uriComponentsBuilder.path("/transacoes/{id}").buildAndExpand(transacaoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(transacaoDto);
	}

}
