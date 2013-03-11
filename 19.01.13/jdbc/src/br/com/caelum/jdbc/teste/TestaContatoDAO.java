package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaContatoDAO {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("Diego Ramos");
		contato.setEmail("rdiego26@gmail.com");
		contato.setEndereco("Rua da curva acentuada 9");
		contato.setDataNascimento(Calendar.getInstance());
		
		// Grave nessa conexão 
		ContatoDAO dao = new ContatoDAO();
		
		dao.adiciona(contato);
		
		System.out.println("Contato Salvo!");
	}
}
