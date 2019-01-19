package com.andersonmarques.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud")
public class CrudController {
	
	@GetMapping("/oi")
	public String paginaTesteSemSufixo() {
		System.out.println("Chamou página de teste sem sufixo.");
		return "oi";//retorna página dentro de main/resources/templates/oi.html
	}
}
