package br.com.bootcamp.carteira.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

	private String ticker;
	private BigDecimal preco;
	private LocalDate data;
	private Integer quantidade;
	private TipoTransacao tipo;

	
	

	

}
