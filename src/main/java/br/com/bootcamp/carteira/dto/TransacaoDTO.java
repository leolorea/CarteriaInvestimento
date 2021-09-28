package br.com.bootcamp.carteira.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.bootcamp.carteira.model.TipoTransacao;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TransacaoDTO {
	
	private String ticker;
	private BigDecimal preco;
	private Integer quantidade;
	private TipoTransacao tipo;

}
