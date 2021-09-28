package br.com.bootcamp.carteira.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootcamp.carteira.dto.UsuarioDTO;
import br.com.bootcamp.carteira.dto.UsuarioFormDTO;
import br.com.bootcamp.carteira.service.ServiceUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private ServiceUsuario service;
	
	@GetMapping
	public List<UsuarioDTO> listar (){
		return service.listar();
	}
		
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid UsuarioFormDTO dto) {
		service.cadastrar(dto);
	}

}
