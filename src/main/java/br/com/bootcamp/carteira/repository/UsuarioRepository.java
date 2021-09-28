package br.com.bootcamp.carteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bootcamp.carteira.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}
