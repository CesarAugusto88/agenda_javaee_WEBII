<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="model.DAO" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo contato</a>
	<h4>Lista de Contatos</h4>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Fone</th>
				<th>Tipo</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="contato" items="${dao.listarContatos()}">
				<tr>
					<td>${contato.nome}</td>
					<td>${contato.fone}</td>
					<td>${contato.tipo}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>