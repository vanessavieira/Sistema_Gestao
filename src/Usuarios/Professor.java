package Usuarios;

public class Professor {
	private String nome;
	private String senha;
	public String email;

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
	/*
	 * public Professor (String nome, String senha, String email){ this.nome =
	 * nome; this.senha = senha; this.email = email; }
	 */
}
