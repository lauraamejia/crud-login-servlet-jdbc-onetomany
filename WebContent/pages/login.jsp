<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
<body>
	<h2>Login</h2>
	<hr/>
	<form id="formLogin" method="POST" action="../FrontController?cmd=logar">
		<label for="login">Login:</label>
		<br/>
		<input type="text" name="login"/>
		<br/><br/>
		<label for="senha">Senha:</label>
		<br/>
		<input type="password" name="senha"/>
		<br/><br/>
		<input type="submit" value="Logar"/>
	</form>
	<br/>
	<div>
		${msg}
	</div>
</body>
</html>