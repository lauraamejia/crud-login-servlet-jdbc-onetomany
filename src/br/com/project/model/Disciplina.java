package br.com.project.model;

import java.util.ArrayList;

public class Disciplina {
	
	private Integer idDisciplina;
	private String nome;
	
	private ArrayList<Aluno> alunos;

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}
	
	public Disciplina(Integer idDisciplina, String nome) {
		this.idDisciplina = idDisciplina;
		this.nome = nome;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nome=" + nome + "]";
	}
	
}
