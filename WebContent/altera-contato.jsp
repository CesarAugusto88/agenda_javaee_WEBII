<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="model.DAO" />
<jsp:useBean id="controller" class="controller.Controller" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar contato</title>
</head>
<body>
<form action="update">
		Id: <input type="text" name="idcon"/><br/>
		Nome: <input type="text" name="nome"/><br/>
		Fone: <input type="text" name="fone"/><br/>
		Fone 2: <input type="text" name="fone2"/><br/>
		E-mail: <input type="text" name="email"/><br/>
		Tipo: <input type="text" name="tipo"/><br/>
		<input type="hidden" name="idcon"value="dao.alterarContato"/>
		<input type="submit" value="Enviar"/>
</form>
</body>
</html>