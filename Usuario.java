package ifrn.poo.projetoLembretes;

import java.util.ArrayList;

public class Usuario {

	private String login;
	private String senha;
	private ArrayList<Notas> arrayDeNotas;
	
	public Usuario(String entradaL, String entradaS){
		this.login = entradaL;
		this.senha = entradaS;
		arrayDeNotas = new ArrayList<Notas>();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Notas> getArrayList(Usuario user){
		return this.arrayDeNotas;
	}
	
	public void setArrayList(Notas nota){
		this.arrayDeNotas.add(nota); // E a ordem por data?
	}
	
}

