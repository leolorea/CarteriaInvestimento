package br.com.bootcamp.carteira.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootcamp.carteira.dto.UsuarioDTO;
import br.com.bootcamp.carteira.dto.UsuarioFormDTO;
import br.com.bootcamp.carteira.model.Usuario;
import br.com.bootcamp.carteira.repository.UsuarioRepository;

@Service

public class ServiceUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
 		return usuarios.stream().map(t -> modelMapper.map(t, UsuarioDTO.class)).collect(Collectors.toList());

	}

	public void cadastrar(UsuarioFormDTO dto) {
		Usuario usuario = modelMapper.map(dto, Usuario.class);
		String senha = new Random().nextInt(99999999) + "";
		usuario.setSenha(senha);
		usuarioRepository.save(usuario);

	}

}
