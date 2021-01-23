package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String fone;
	private String fone2;
	private String email;
	private String tipo;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idcon, String nome, String fone, String fone2, String email, String tipo) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.fone2 = fone2;
		this.email = email;
		this.tipo = tipo;
	}

	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
