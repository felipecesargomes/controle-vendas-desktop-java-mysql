package br.com.felipe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	/**
	 * @author Felipe César
	 */
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC","vendas","123");
		} catch(Exception erro) {
			throw new RuntimeException(erro);
		}
	}
	
}