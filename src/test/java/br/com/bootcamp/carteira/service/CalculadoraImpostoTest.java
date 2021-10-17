package br.com.bootcamp.carteira.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.bootcamp.carteira.model.TipoTransacao;
import br.com.bootcamp.carteira.model.Transacao;

class CalculadoraImpostoTest {

	@Test
	void calculoImpostoTransacaoTipoCompraDeveSerZero() {
		Transacao transacao = new Transacao();
		transacao.setPreco(new BigDecimal("38.12"));
		transacao.setQuantidade(3000);
		transacao.setTipo(TipoTransacao.COMPRA);
		CalculadoraImposto calculadora = new CalculadoraImposto();
		BigDecimal resultado = calculadora.calcularImposto(transacao);
		
		assertEquals(BigDecimal.ZERO, resultado);
	}
	
	@Test
	void calculoImpostoTransacaoVendaMenorVinteMilDeveSerZero() {
		Transacao transacao = new Transacao();
		transacao.setPreco(new BigDecimal("38.12"));
		transacao.setQuantidade(300);
		transacao.setTipo(TipoTransacao.COMPRA);
		CalculadoraImposto calculadora = new CalculadoraImposto();
		BigDecimal resultado = calculadora.calcularImposto(transacao);
		
		assertEquals(BigDecimal.ZERO, resultado);
	}
	

	@Test
	void calculoImpostoTransacaoVendaMaiorVinteMilDeveSerQuinzePorcento() {
		Transacao transacao = new Transacao();
		transacao.setPreco(new BigDecimal("38.12"));
		transacao.setQuantidade(10000);
		transacao.setTipo(TipoTransacao.VENDA);
		CalculadoraImposto calculadora = new CalculadoraImposto();
		BigDecimal resultado = calculadora.calcularImposto(transacao);
		
		BigDecimal volumeTransacao = transacao.getPreco().multiply(new BigDecimal(transacao.getQuantidade()));
		System.out.println(volumeTransacao);
		System.out.println(resultado);
		assertEquals(volumeTransacao.multiply(new BigDecimal(.15)).setScale(2, RoundingMode.HALF_UP), resultado);
	}

}
