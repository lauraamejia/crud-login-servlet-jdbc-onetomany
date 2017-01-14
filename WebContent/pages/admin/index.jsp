<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<jsp:useBean id="disciplinaDao" class="br.com.project.dao.DisciplinaDao"/>
	</head>
<body>
	<div>${usuario}</div>
	<hr/>
	<h2>Cadastro de Aluno</h2>
	<hr/>
	<form id="formCadastro" method="POST" action="../../FrontController?cmd=gravar">
		<label for="nome">Nome do aluno:</label>
		<br/>
		<input type="text" name="nome"/>
		<br/><br/>
		<label for="email">Email:</label>
		<br/>
		<input type="text" name="email"/>
		<br/><br/>
		<label for="disciplina">Disciplina:</label>
		<br/>
		<select name="disciplina">
			<option disabled="disabled" selected="selected">Escolha a Disciplina</option>
			<c:forEach items="${disciplinaDao.findAll}" var="line">
				<option value="${line.idDisciplina}">${line.nome}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<input type="submit" value="Cadastrar Aluno"/>
	</form>
</body>
</html>