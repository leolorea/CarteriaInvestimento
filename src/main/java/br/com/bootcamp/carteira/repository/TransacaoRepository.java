package br.com.bootcamp.carteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bootcamp.carteira.model.Transacao;


public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}