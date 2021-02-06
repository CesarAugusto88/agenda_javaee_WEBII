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

@WebServlet(urlPatterns = { "/main" })
public class ListarContatosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();

	public ListarContatosController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("contatos", dao.listarContatos());
	
		request.getRequestDispatcher("agenda.jsp").forward(request, response);
	
	}

}
