<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Editar</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<jsp:useBean id="disciplinaDao" class="br.com.project.dao.DisciplinaDao"/>
	</head>
<body>
	<h2>Editar</h2>
	<hr/>
	<form id="formEditar" method="POST" action="FrontController?cmd=editar">	
		<input type="hidden" name="idAluno" value="${alunoDisciplinaDto.idAluno}"/>
		<label for="nome">Nome do aluno:</label>
		<br/>
		<input type="text" name="nome" value="${alunoDisciplinaDto.nome}"/>
		<br/><br/>
		<label for="email">Email:</label>
		<br/>
		<input type="text" name="email" value="${alunoDisciplinaDto.email}"/>
		<br/><br/>
		<label for="disciplina">Disciplina:</label>
		<br/>
		<select name="disciplina">
			<option selected="selected" value="${alunoDisciplinaDto.idDisciplina}">${alunoDisciplinaDto.nomeDisciplina}</option>
			<c:forEach items="${disciplinaDao.findAll}" var="line">
				<option value="${line.idDisciplina}">${line.nome}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<input type="submit" value="Alterar Aluno"/>
	</form>
</body>
</html>