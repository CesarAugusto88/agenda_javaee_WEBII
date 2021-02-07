<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="contato" class="model.JavaBeans"  scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar contato</title>
</head>
<body>
<form action="update">
		Id: <%=contato.getIdcon()%><br/>
		Nome: <input type="text" name="nome" value="<%=contato.getNome()%>"/><br/>
		Fone: <input type="text" name="fone" value="<%=contato.getFone()%>"/><br/>
		Fone 2: <input type="text" name="fone2" value="<%=contato.getFone2()%>"/><br/>
		E-mail: <input type="text" name="email" value="<%=contato.getEmail()%>"/><br/>
		Tipo: <input type="text" name="tipo" value="<%=contato.getTipo()%>"/><br/>
		<input type="hidden" name="idcon" value="<%=contato.getIdcon()%>"/>
		<input type="submit" value="Enviar"/>
</form>
</body>
</html>