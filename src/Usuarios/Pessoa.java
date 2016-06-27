package Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pessoa {

	public String nome;
	private String senha;
	public String email;
	public String alocou;
	public String atividade;
	
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
	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

}
