package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DAO {
	/** Modulo de conexao **/
	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Ads_12345";

	// Metodo de conexao
	private Connection conectar() throws Exception {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	public static interface RegraDeNegocio<R> {
		R executar(Connection con) throws Exception;
	}

	private <T> T executar(RegraDeNegocio<T> funcao) throws Exception {

		Connection con = conectar();
		try {
			T retorno = funcao.executar(con);
			// Encerrar a conexão com o banco de dados
			con.commit();
			return retorno;
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw e1;
			}
			throw e;
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				throw e1;
			}

		}

	}
	// teste de conexao
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		try {

			executar((con) -> {
				// Preparar a query para execução no banco de dados
				String create = "insert into contatos (nome,fone,fone2,email,tipo) values (?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
				pst.setString(1, contato.getNome());
				pst.setString(2, contato.getFone());
				pst.setString(3, contato.getFone2());
				pst.setString(4, contato.getEmail());
				pst.setString(5, contato.getTipo());
				// Executar a query
				return pst.executeUpdate();
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//// MVC

	//// MODEL
	//// VIEW
	//// CONTROLLER

	//// REQ -> Controller -> Model -> Controller -> View

	///// Controller
	//// -> MODEL
	//// <-
	//// -> VIEW
	//// <-

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		try {
			return executar((con) -> {
				ArrayList<JavaBeans> contatos = new ArrayList<>();
				String read = "select * from contatos order by nome";
				PreparedStatement pst = con.prepareStatement(read);
				ResultSet rs = pst.executeQuery();
				// O laço abaixo será executado enquanto houver contatos
				while (rs.next()) {
					// variaveis de apoio que recebem dados do banco
					String idcon = rs.getString(1);
					String nome = rs.getString(2);
					String fone = rs.getString(3);
					String fone2 = rs.getString(4);
					String email = rs.getString(5);
					String tipo = rs.getString(6);
					// populando o ArrayList
					contatos.add(new JavaBeans(idcon, nome, fone, fone2, email, tipo));
				}
				return contatos;
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * CRUD UPDATE
	 * 
	 * @throws Exception
	 **/
	public int alterarContato(JavaBeans contato) throws Exception {
		return executar(con -> {
			String sql = "update contatos set nome=?, fone=?, fone2=?, email=?, tipo=? where idcon=?";
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(sql);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			int i = 1;
			pst.setString(i++, contato.getNome());
			pst.setString(i++, contato.getFone());
			pst.setString(i++, contato.getFone2());
			pst.setString(i++, contato.getEmail());
			pst.setString(i++, contato.getTipo());
			pst.setString(i++, contato.getIdcon());

			return pst.executeUpdate();
		});
	}

	/** CRUD DELETE **/
	/*
	 * public void removerContato(JavaBeans contato) { String delete =
	 * "delete from contatos where idcon=?"; try { // abrir a conexao Connection con
	 * = conectar(); // Preparar a query para execução no banco de dados
	 * PreparedStatement pst = con.prepareStatement(delete); // Substituir os
	 * parâmetros (?) pelo conteúdo das variáveis JavaBeans pst.setString(1,
	 * contato.getIdcon()); // Executar a query pst.executeUpdate(); // Encerrar a
	 * conexão com o banco de dados con.close();
	 * 
	 * } catch (Exception e) { System.out.println(e); } }
	 */
	public int removerContato(JavaBeans contato) throws Exception {
		return executar(con -> {

	/** CRUD DELETE 
	 * @throws Exception **/
	public void removerContato(JavaBeans contato) throws Exception {
		executar(con -> {

			String delete = "delete from contatos where idcon=?";
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(delete);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getIdcon());
			// Executar a query

			pst.executeUpdate();

			return pst.executeUpdate();
		});
	}

	public Optional<JavaBeans> buscarContato(String idconRef) throws Exception {
		return executar((con) -> {
			String sql = "select * from contatos where idcon=?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, idconRef);
			ResultSet rs = query.executeQuery();
			if (!rs.next()) {
				return Optional.empty();
			}

			String idcon = rs.getString(1);
			String nome = rs.getString(2);
			String fone = rs.getString(3);
			String fone2 = rs.getString(4);
			String email = rs.getString(5);
			String tipo = rs.getString(6);
			JavaBeans contato = new JavaBeans(idcon, nome, fone, fone2, email, tipo);
			return Optional.of(contato);
		});
	}

}