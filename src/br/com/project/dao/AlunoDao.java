package br.com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.project.connection.ConnectionFactory;
import br.com.project.dto.AlunoDisciplinaDto;
import br.com.project.model.Aluno;

public class AlunoDao {

	Connection con = new ConnectionFactory().getConnection();
	PreparedStatement stmt;
	ResultSet rs;
	
	public void create(Aluno a) throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("insert into aluno values(null,?,?)",
				Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, a.getNome());
				stmt.setString(2, a.getEmail());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			rs.next();
			int key = rs.getInt(1);
			a.setIdAluno(key);
		stmt = con.prepareStatement("insert into disciplina values(?,?,?)");
				stmt.setInt(1, a.getDisciplina().getIdDisciplina());
				stmt.setString(2, a.getDisciplina().getNome());
				stmt.setInt(3, a.getIdAluno());
			stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<AlunoDisciplinaDto> getFindAll() throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("select * from aluno inner join disciplina on aluno.idAluno = disciplina.id_aluno order by idAluno");
			rs = stmt.executeQuery();
			List<AlunoDisciplinaDto> lista = new ArrayList<>();
			AlunoDisciplinaDto alunoDisciplinaDto;
			while (rs.next()) {
				alunoDisciplinaDto = new AlunoDisciplinaDto();
				alunoDisciplinaDto.setIdAluno(rs.getInt(1));
				alunoDisciplinaDto.setNome(rs.getString(2));
				alunoDisciplinaDto.setEmail(rs.getString(3));
				alunoDisciplinaDto.setIdDisciplina(rs.getInt(4));
				alunoDisciplinaDto.setNomeDisciplina(rs.getString(5));
				lista.add(alunoDisciplinaDto);
			}
		stmt.close();
		con.close();
		return lista;
	}
	
	public AlunoDisciplinaDto findByCod(Integer cod) throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("select * from aluno inner join disciplina on aluno.idAluno = disciplina.id_aluno where idAluno = " + cod);
			rs = stmt.executeQuery();
			AlunoDisciplinaDto alunoDisciplinaDto = new AlunoDisciplinaDto();
			if (rs.next()) {
				alunoDisciplinaDto.setIdAluno(rs.getInt(1));
				alunoDisciplinaDto.setNome(rs.getString(2));
				alunoDisciplinaDto.setEmail(rs.getString(3));
				alunoDisciplinaDto.setIdDisciplina(rs.getInt(4));
				alunoDisciplinaDto.setNomeDisciplina(rs.getString(5));
			}
		stmt.close();
		con.close();
		return alunoDisciplinaDto;
	}
	
	public void update(Aluno a) throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("update aluno set nome = ?, email = ? where idAluno = " + a.getIdAluno());
				stmt.setString(1, a.getNome());
				stmt.setString(2, a.getEmail());
			stmt.execute();
		stmt = con.prepareStatement("update disciplina set idDisciplina = ?, nome = ? where id_aluno = " + a.getIdAluno());
				stmt.setInt(1, a.getDisciplina().getIdDisciplina());
				stmt.setString(2, a.getDisciplina().getNome());
			stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		stmt = con.prepareStatement("delete from aluno where idAluno=" + id);
			stmt.execute();
		stmt.close();
		con.close();
	}
	
}
