package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		// teste de conexao
		// dao.testeConexao();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Agenda contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans (de model DAO)
		// ArrayList<JavaBeans> lista = dao.listarContatos();
		// teste de recebimento da lista
		/*
		 * for (int i = 0; i < lista.size(); i++) { // Acessando os metodos públicos da
		 * classe JavaBeans System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getFone());
		 * System.out.println(lista.get(i).getFone2());
		 * System.out.println(lista.get(i).getEmail());
		 * System.out.println(lista.get(i).getTipo()); }
		 */

		response.sendRedirect("agenda.jsp");
	}

	// Insert novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento dos dados do formulário
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("fone2"));
		 * System.out.println(request.getParameter("email"));
		 * System.out.println(request.getParameter("tipo"));
		 */
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
