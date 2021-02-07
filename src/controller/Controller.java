package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/edit", "/update", "/delete"})
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		// teste de conexao
		// dao.testeConexao();

		if (action.equals("/edit")) {
			abrirContato(request, response);
		} else if (action.equals("/update")) {
			alteraContato(request, response);
		} else if (action.equals("/delete")) {
			deleteContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Abrir contato
	protected void abrirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String idcon = request.getParameter("idcon");
			Optional<JavaBeans> contatoRefencia = dao.buscarContato(idcon);
			RequestDispatcher rd = null;
			if (contatoRefencia.isPresent()) {
				request.setAttribute("contato", contatoRefencia.get());
				rd = request.getRequestDispatcher("altera-contato.jsp");
			} else {
				request.setAttribute("mensagem", "Não foi encontrado o contato com o id " + idcon);
				rd = request.getRequestDispatcher("agenda.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("error-contato-nao-encontrado.jsp");
		}

	}

	// Altera contato
	protected void alteraContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JavaBeans contato = new JavaBeans();

		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setFone2(request.getParameter("fone2"));
		contato.setEmail(request.getParameter("email"));
		contato.setTipo(request.getParameter("tipo"));

		try {
			dao.alterarContato(contato);
			response.sendRedirect("agenda.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error-editar.jsp");
		}
	}

	// Delete contato
	protected void deleteContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JavaBeans contato = new JavaBeans();

		contato.setIdcon(request.getParameter("idcon"));

		try {
			dao.removerContato(contato);
			response.sendRedirect("agenda.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("main");
		}
	}

}
