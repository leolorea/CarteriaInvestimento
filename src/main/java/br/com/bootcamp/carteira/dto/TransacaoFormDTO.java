package br.com.bootcamp.carteira.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import br.com.bootcamp.carteira.model.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoFormDTO {
	
	@NotEmpty
	@NotNull
	@Size (min = 4, max = 5)
	@PerformanceSensitive
	private String ticker;
	
	@NotNull
	@DecimalMin("0.01")
	private BigDecimal preco;
	
	@PastOrPresent
	@NotNull
	private LocalDate data;
	
	@Positive
	@Min(100)
	
	private Integer quantidade;
	
	@NotNull
	@JsonEnumDefaultValue
	private TipoTransacao tipo;
	
	@JsonAlias("usuario_id")
	private Long usuarioId;

}
