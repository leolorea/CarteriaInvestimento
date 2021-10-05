package br.com.bootcamp.carteira.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	
	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String login;

}
