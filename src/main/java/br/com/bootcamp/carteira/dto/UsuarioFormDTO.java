package br.com.bootcamp.carteira.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class UsuarioFormDTO {
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String senha;
	
	@NotEmpty
	private String login;

}
