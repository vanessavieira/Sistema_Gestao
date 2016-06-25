package Usuarios;

import java.util.ArrayList;

import recursos.Recursos;

public class Pessoa {

	public String nome;
	private String senha;
	public String email;
	
	ArrayList<Recursos> historicoAlocacao = new ArrayList<Recursos>();
	
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
	
	public void adicionarHistoricoAlocacao (Recursos recursos){
		historicoAlocacao.add(recursos);
	}
	
}
