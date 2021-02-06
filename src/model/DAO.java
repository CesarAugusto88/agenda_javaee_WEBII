package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Modulo de conexao **/
	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Ads_12345";

	// Metodo de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
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
		String create = "insert into contatos (nome,fone,fone2,email,tipo) values (?,?,?,?,?)";
		try {
			// abrir a conexao
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getFone2());
			pst.setString(4, contato.getEmail());
			pst.setString(5, contato.getTipo());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
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
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/
	public int alterarContato(JavaBeans contato) {
		String sql = "update contatos set nome=?, fone=?, fone2=?, email=?, tipo=? where idcon=?";
		try {
			// abrir a conexao
			Connection con = conectar();
			int i = 1;
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(sql);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(i++, contato.getNome());
			pst.setString(i++, contato.getFone());
			pst.setString(i++, contato.getFone2());
			pst.setString(i++, contato.getEmail());
			pst.setString(i++, contato.getTipo());
			pst.setString(i++, contato.getIdcon());
			
			int cod = pst.executeUpdate();
			
			return cod;

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/** CRUD DELETE **/
	public void removerContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon=?";
		try {
			// abrir a conexao
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(delete);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getIdcon());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}