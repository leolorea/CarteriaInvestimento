package br.com.bootcamp.carteira.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootcamp.carteira.dto.TransacaoDto;
import br.com.bootcamp.carteira.dto.TransacaoFormDTO;
import br.com.bootcamp.carteira.service.ServiceTransacoes;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	@Autowired
	private ServiceTransacoes service;

	@GetMapping

	public List<TransacaoDto> listar() {
		return service.listaTransacoes();

	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid TransacaoFormDTO dto) {
		service.cadastrar(dto);
	}

}
