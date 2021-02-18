<%@ page
	import="java.util.*,
				model.JavaBeans,
				controller.Controller"%>

<!-- TESTE  para listar em agenda.jsp
	 Fonte: https://www.caelum.com.br/apostila/apostila-java-web.pdf-->
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
	<a href="novo.html" class="Botao1">Novo contatos</a>
	<h4>Lista de Contatos</h4>
	<table>
		<%
		DAO dao = new DAO();
		List<JavaBeans> contatos = dao.listarContatos();
		for (JavaBeans contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getFone()%></td>
			<td><%=contato.getTipo()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>