<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="contato" class="model.JavaBeans" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar contato</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmContato" action="update" style="display: inline">
		Id:
		<%=contato.getIdcon()%><br /> Nome: <input type="text" name="nome"
			class="Caixa1" value="<%=contato.getNome()%>" /><br /> Fone: <input
			type="text" name="fone" class="Caixa2" value="<%=contato.getFone()%>" /><br />
		Fone 2: <input type="text" name="fone2" class="Caixa2"
			value="<%=contato.getFone2()%>" /><br /> E-mail: <input type="text"
			name="email" class="Caixa1" value="<%=contato.getEmail()%>" /><br />
		Tipo: <input type="text" name="tipo" class="Caixa1"
			value="<%=contato.getTipo()%>" /><br /> <input type="hidden"
			name="idcon" value="<%=contato.getIdcon()%>" /> <input type="button"
			value="Enviar" class="Botao1" onclick="validar()">
	</form>
	<a href="main">
		<button class="Botao1">Cancelar</button>
	</a>
	<script src="scripts/validador.js"></script>
</body>
</html>