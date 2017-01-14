<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Consulta</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<jsp:useBean id="alunoDao" class="br.com.project.dao.AlunoDao"/>
	</head>
<body>
	<h2>Consulta de Alunos</h2>
	<hr/>
	<table border="1">
		<thead>
			<tr>
				<th>Id do Aluno</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Disciplina</th>
				<th>Operações</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${alunoDao.findAll}" var="line">
				<tr>
					<td>${line.idAluno}</td>
					<td>${line.nome}</td>
					<td>${line.email}</td>
					<td>${line.nomeDisciplina}</td>
					<td><a href="../../FrontController?cmd=excluir&idAluno=${line.idAluno}">Excluir</a> | <a href="../../FrontController?cmd=alterar&idAluno=${line.idAluno}">Alterar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>