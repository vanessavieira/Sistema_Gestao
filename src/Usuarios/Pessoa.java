package Usuarios;

public class Pessoa {

	public String nome;
	private String senha;
	public String email;
	public String alocou;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAlocou() {
		return alocou;
	}

	public void setAlocou(String alocou) {
		this.alocou = alocou;
	}
	
}
