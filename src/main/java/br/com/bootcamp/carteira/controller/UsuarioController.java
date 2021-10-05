package br.com.bootcamp.carteira.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bootcamp.carteira.dto.UsuarioDto;
import br.com.bootcamp.carteira.dto.UsuarioFormDto;
import br.com.bootcamp.carteira.service.ServiceUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private ServiceUsuario service;
	
	@GetMapping
	public Page<UsuarioDto> listar (@PageableDefault(size=10) Pageable pageable){
		return service.listar(pageable);
	}
		
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioFormDto dto, UriComponentsBuilder builder) {
		UsuarioDto usuarioDto = service.cadastrar(dto);
		
		URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuarioDto.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(usuarioDto);
	}

}
