package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

}