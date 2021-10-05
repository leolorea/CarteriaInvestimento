package br.com.bootcamp.carteira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootcamp.carteira.dto.ItemCarteiraDto;
import br.com.bootcamp.carteira.service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {
	
	
	@Autowired
	private RelatorioService service;

	@GetMapping("/carteira")
	public List<ItemCarteiraDto> realtorioCarteiraInvestimentos(){
		return service.relatorioCarteiraDeInvestimentos();
	}
}
