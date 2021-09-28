package br.com.bootcamp.carteira.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class UsuarioFormDTO {
	
	@NotEmpty
	private String nome;
	
	
	private String senha;
	
	@NotEmpty
	private String login;
	
	@JsonAlias("usuario_id")
	private Long usuarioId;

}
