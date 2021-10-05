package br.com.bootcamp.carteira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemCarteiraDto {
	
	
	private String ticker;
	private Long quantidade;
	private Double percentual;

}
