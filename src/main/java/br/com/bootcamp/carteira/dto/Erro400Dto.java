package br.com.bootcamp.carteira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Erro400Dto {

	private String mensagem;
	private String campo;
	
}
