<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="contatos" type="java.util.ArrayList<model.JavaBeans>" scope="request" />
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
	<h3>Lista de Contatos</h3>
	<%
		String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null) {
	%>
	<div><%=mensagem%></div>
	<%
		}
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Fone 2</th>
				<th>E-mail</th>
				<th>Tipo</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="contato" items="${dao.listarContatos()}">
				<tr>
					<td>${contato.idcon}</td>
					<td>${contato.nome}</td>
					<td>${contato.fone}</td>
					<td>${contato.fone2}</td>
					<td>${contato.email}</td>
					<td>${contato.tipo}</td>
					<td><a href="edit?idcon=${contato.idcon}"
						style="color: green;">Alterar</a> | <a href="delete?idcon=${contato.idcon}" style="color: red;"
						onclick="return confirm('Tem certeza que deseja remover esse registro?');">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>