<%@ page import="java.util.*,
				model.*,
				controller.*"%>

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
		<%
		DAO dao = new DAO();
		List<JavaBeans> contatos = dao.listarContatos();
		for (JavaBeans contato : contatos) {
		%>
		<tbody>
			<tr>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getFone()%></td>
				<td><%=contato.getTipo()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
</body>
</html>