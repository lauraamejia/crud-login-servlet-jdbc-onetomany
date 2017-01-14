package br.com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.project.connection.ConnectionFactory;
import br.com.project.model.Disciplina;

public class DisciplinaDao {
	
	Connection con = new ConnectionFactory().getConnection();
	PreparedStatement stmt;
	ResultSet rs;
	
	public List<Disciplina> getFindAll() throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("select * from disciplina group by idDisciplina");
			rs = stmt.executeQuery();
			List<Disciplina> lista = new ArrayList<>();
			Disciplina disciplina;
			while (rs.next()) {
				disciplina = new Disciplina(rs.getInt(1), rs.getString(2));
				lista.add(disciplina);
			}
		stmt.close();
		con.close();
		return lista;
	}
	
	public Disciplina findByCod(Integer cod) throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("select * from disciplina where idDisciplina = " + cod);
			rs = stmt.executeQuery();
			Disciplina disciplina = new Disciplina();
			if (rs.next()) {
				disciplina.setIdDisciplina(rs.getInt(1));
				disciplina.setNome(rs.getString(2));
			}
		stmt.close();
		con.close();
		return disciplina;
	}
	
}
