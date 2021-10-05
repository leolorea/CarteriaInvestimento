package br.com.bootcamp.carteira.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bootcamp.carteira.dto.TransacaoDto;
import br.com.bootcamp.carteira.dto.TransacaoFormDto;
import br.com.bootcamp.carteira.model.Transacao;
import br.com.bootcamp.carteira.repository.TransacaoRepository;

@Service
public class ServiceTransacoes {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Page<TransacaoDto> listaTransacoes(Pageable paginacao) {
		Page<Transacao> transacoes = transacaoRepository.findAll(paginacao);
		return transacoes
				.map(t -> modelMapper
				.map(t, TransacaoDto.class));
	}

	@Transactional
	public TransacaoDto cadastrar(TransacaoFormDto dto) {
	
			Transacao transacao = modelMapper.map(dto, Transacao.class);
			transacao.setId(null);
			transacaoRepository.save(transacao);
			return modelMapper.map(transacao,TransacaoDto.class);
		
	}
}
