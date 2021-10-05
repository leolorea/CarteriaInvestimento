package br.com.bootcamp.carteira.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transacoes") 
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ticker;
	private BigDecimal preco;
	private LocalDate data;
	private Integer quantidade;
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipo;
	
	@ManyToOne
	private Usuario usuario;

	
	

	

}
