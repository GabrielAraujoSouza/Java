package javaavancado.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe gerencia a cria��o de conex�es com o banco de dados
 */
public class ConnectionFactory {
	
	/**
	 * Obt�m uma conex�o com o banco de dados
	 * @return Conex�o com o banco de dados
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		/*
		 * Este exemplo � baseado no acesso a um banco de dados PostgreSQL que possui um banco de dados
		 * chamado 'agendadb'
		 */
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/agendadb";
		String userName = "postgres";
		String password = "postgres";
		
		try {
			//faz o processo de obten��o da conex�o via JDBC
			Class.forName(driverClass);
			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
			
		} catch (ClassNotFoundException e) {
			throw new SQLException("O driver n�o foi encontrado");
		}
	}
}
