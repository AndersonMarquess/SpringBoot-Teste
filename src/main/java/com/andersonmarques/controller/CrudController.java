package com.andersonmarques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andersonmarques.service.DatabaseService;

@Controller
@RequestMapping("/crud")
public class CrudController {
	
	@Autowired
	private DatabaseService databaseService;

	/**
	 * Endpoint para popular banco de dados.
	 * Disponível no caminho localhost:8080/crud/popular
	 * @return
	 */
	@GetMapping("/popular")
	public String popularBancoDeDados() {
		databaseService.popularBancoDeDados();
		return "/popular";//retorna página dentro de main/resources/templates/popular.html
	}
}
