package br.com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.project.connection.ConnectionFactory;
import br.com.project.model.Usuario;

public class UsuarioDao {
	
	Connection con = new ConnectionFactory().getConnection();
	PreparedStatement stmt;
	ResultSet rs;
	
	public Usuario findByUsuario(Usuario u) throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("select * from usuario where login = '" + u.getLogin() + "' and senha = '" + u.getSenha() + "'");
			rs = stmt.executeQuery();
			Usuario usuario = new Usuario();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setLogin(rs.getString(2));
				usuario.setSenha(rs.getString(3));
			} else {
				usuario=null;
			}
		stmt.close();
		con.close();
		return usuario;
	}
	
}
