package br.com.caelum.jdbc.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) throws ParseException {
		
		ContatoDAO dao = new ContatoDAO();
		List<Contato> listaContatos = dao.getLista();
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
				for(Contato c: listaContatos) {
			System.out.println("Nome: " + c.getNome());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Endereço: " + c.getEndereco());
			System.out.println("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento().getTime()) );
			System.out.println("\n");
		}
	}
	
}
