package br.com.bootcamp.carteira.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootcamp.carteira.dto.TransacaoDto;
import br.com.bootcamp.carteira.dto.TransacaoFormDTO;
import br.com.bootcamp.carteira.model.Transacao;
import br.com.bootcamp.carteira.repository.TransacaoRepository;

@Service
public class ServiceTransacoes {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<TransacaoDto> listaTransacoes() {
		List<Transacao> transacoes = transacaoRepository.findAll();
		return transacoes
				.stream()
				.map(t -> modelMapper
				.map(t, TransacaoDto.class))
				.collect(Collectors.toList());
	}

	public void cadastrar(TransacaoFormDTO dto) {
	
			Transacao transacao = modelMapper.map(dto, Transacao.class);
			transacaoRepository.save(transacao);
		
	}
}
