package br.com.bootcamp.carteira.service;

import java.util.Random;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bootcamp.carteira.dto.UsuarioDto;
import br.com.bootcamp.carteira.dto.UsuarioFormDto;
import br.com.bootcamp.carteira.model.Usuario;
import br.com.bootcamp.carteira.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public Page<UsuarioDto> listar(Pageable pageable) {
		Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
 		return usuarios.map(t -> modelMapper.map(t, UsuarioDto.class));

	}
	
	@Transactional
	public UsuarioDto cadastrar(UsuarioFormDto dto) {
		Usuario usuario = modelMapper.map(dto, Usuario.class);
		String senha = new Random().nextInt(99999999) + "";
		usuario.setSenha(senha);
		usuarioRepository.save(usuario);
		
		return modelMapper.map(usuario, UsuarioDto.class);

	}

}
