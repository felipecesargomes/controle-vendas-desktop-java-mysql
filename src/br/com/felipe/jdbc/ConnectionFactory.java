package br.com.felipe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC","vendas","1233");
		} catch(Exception erro) {
			throw new RuntimeException(erro);
		}
	}
	
}