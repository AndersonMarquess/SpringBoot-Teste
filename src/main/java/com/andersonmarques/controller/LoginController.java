package com.andersonmarques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.andersonmarques.service.UsuarioAutenticavelService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioAutenticavelService usuarioAutenticavelService;

	@GetMapping("/login")
	public String loginPage() {
		return "login"; //login.html
	}
	
	/**
	 * Endpoint para criar o admin inicial do sistema.
	 * @return
	 */
	@GetMapping("/popular-users")
	public String popularUsers() {
		usuarioAutenticavelService.criarAdminMock();
		return "login";
	}
}
