package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/insert" })
public class NovoContatoController extends HttpServlet {

	DAO dao = new DAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JavaBeans contato = new JavaBeans();
		// Setar as variaveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setFone2(request.getParameter("fone2"));
		contato.setEmail(request.getParameter("email"));
		contato.setTipo(request.getParameter("tipo"));
		// Invocar o metodo inserirContato passando o objeto contato
		dao.inserirContato(contato);
		// redirecionamento para o documento agenda.jsp
		response.sendRedirect("main");
	}

}
