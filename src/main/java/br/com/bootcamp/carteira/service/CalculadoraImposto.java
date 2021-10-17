package br.com.bootcamp.carteira.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.bootcamp.carteira.model.TipoTransacao;
import br.com.bootcamp.carteira.model.Transacao;

public class CalculadoraImposto {
	
	
	public BigDecimal calcularImposto(Transacao transacao) {
		if (transacao.getTipo()==TipoTransacao.COMPRA){
				
			return BigDecimal.ZERO;}
		
		BigDecimal volumeTransacao = transacao.getPreco().multiply(new BigDecimal(transacao.getQuantidade()));
			if(volumeTransacao.compareTo(new BigDecimal(20000))<0) {
				
				return BigDecimal.ZERO;
			}
		return (volumeTransacao.multiply(new BigDecimal("0.15"))).setScale(2, RoundingMode.HALF_UP);
		
		
	}

}
