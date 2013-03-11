package br.com.caelum.jdbc.dao;

public class DAOException extends RuntimeException {

	
	public DAOException(Exception e)
	{
		System.out.println("Erro" + e.getMessage());
	}
}
