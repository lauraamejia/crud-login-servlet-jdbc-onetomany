package br.com.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd", "root", "senha");
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
