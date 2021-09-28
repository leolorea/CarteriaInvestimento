package br.com.bootcamp.carteira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.bootcamp.carteira.dto.UsuarioDTO;
import br.com.bootcamp.carteira.dto.UsuarioFormDTO;
import br.com.bootcamp.carteira.model.Usuario;

@Service

public class ServiceUsuario {

	private static List<Usuario> usuarios = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();

	public List<UsuarioDTO> listar() {
		return usuarios.stream().map(t -> modelMapper.map(t, UsuarioDTO.class)).collect(Collectors.toList());

	}

	public void cadastrar(UsuarioFormDTO dto) {
		Usuario usuario = modelMapper.map(dto, Usuario.class);
		usuarios.add(usuario);

	}

}
