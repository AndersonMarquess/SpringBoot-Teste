package com.andersonmarques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.andersonmarques.model.Usuario;
import com.andersonmarques.service.UsuarioAutenticavelService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioAutenticavelService usuarioAutenticavelService;

	@GetMapping("/login")
	public String loginPage() {
		return "login"; // login.html
	}

	@GetMapping("/cadastrar")
	public String novo(Usuario usuario) {
		return "/usuario/criar-usuario";
	}

	@PostMapping("/adicionar")
	public String adicionar(Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return novo(usuario);
		}
		usuarioAutenticavelService.adicionar(usuario);
		return "redirect:/tarefa/listar";
	}
}
