package br.com.project.dto;

public class AlunoDisciplinaDto {
	
	private Integer idAluno;
	private String nome;
	private String email;
	private Integer idDisciplina;
	private String nomeDisciplina;
	
	public Integer getIdAluno() {
		return idAluno;
	}
	
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	@Override
	public String toString() {
		return "AlunoDisciplinaDto [idAluno=" + idAluno + ", nome=" + nome + ", email=" + email + ", idDisciplina="
				+ idDisciplina + ", nomeDisciplina=" + nomeDisciplina + "]";
	}
	
}
