package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {

	 // A conexão com o banco de dados 
	 private Connection conexao;
	 
	 public ContatoDAO() {
		 this.conexao = new ConnectionFactory().getConnection();
	 }
	 
	 public void adiciona(Contato contato) {
		 String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES(?, ?, ?, ?)";
		 
		 try {
			//PREPARED STATEMENT para INSERÇÃO
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			 
			 //Seta os valores
			 stmt.setString(1, contato.getNome());
			 stmt.setString(2, contato.getEmail());
			 stmt.setString(3, contato.getEndereco());
			 stmt.setDate(4, new Date ( contato.getDataNascimento().getTimeInMillis() ) );
			 
			 //Executa
			 stmt.execute();
			 stmt.close();
			 
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	 }
	 
	 public List<Contato> getLista() {
		 try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM contatos ORDER BY nome");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//Cria objeto Contato
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				//Montando a data através do Calendar
				Calendar dt = Calendar.getInstance();
				dt.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(dt);
				
				//Adicionando o objeto à lista
				contatos.add(c);
			}
			
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	 }
}
