package br.com.bootcamp.carteira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootcamp.carteira.dto.ItemCarteiraDto;
import br.com.bootcamp.carteira.repository.TransacaoRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private TransacaoRepository repository;

	public List<ItemCarteiraDto> relatorioCarteiraDeInvestimentos() {
		return repository.relatorioCarteiraDeInvestimentos();
		
		
	
		
	}

	

}
