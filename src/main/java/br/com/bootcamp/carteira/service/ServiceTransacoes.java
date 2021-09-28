package br.com.bootcamp.carteira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bootcamp.carteira.dto.TransacaoDTO;
import br.com.bootcamp.carteira.dto.TransacaoFormDTO;
import br.com.bootcamp.carteira.model.Transacao;

@Service
public class ServiceTransacoes {

	private List<Transacao> transacoes = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();

	public List<TransacaoDTO> listaTransacoes() {

		return transacoes
				.stream()
				.map(t -> modelMapper
				.map(t, TransacaoDTO.class))
				.collect(Collectors.toList());
	}

	public void cadastrar(TransacaoFormDTO dto) {
	
			Transacao transacao = modelMapper.map(dto, Transacao.class);
			transacoes.add(transacao);
		
	}
}
