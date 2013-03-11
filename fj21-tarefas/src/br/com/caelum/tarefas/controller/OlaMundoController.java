package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "ok"; //retorna o nome da página(JSP) que será chamada, a extensão fui suprimida pois será configurado para o Spring colocar a extensão
	}
	
	
}
