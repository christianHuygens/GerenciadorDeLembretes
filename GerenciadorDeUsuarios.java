package ifrn.poo.projetoLembretes;

import ifrn.poo.excecao.UsuarioExistenteException;
import ifrn.poo.excecao.UsuarioSenhaErradoException;

import java.util.ArrayList;

public class GerenciadorDeUsuarios {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public void cadastrar(Usuario usuario) throws UsuarioExistenteException {
		if (checarNomes(usuario.getLogin())) {
			throw new UsuarioExistenteException();
		}
		this.usuarios.add(usuario);
	}

	public boolean checarNomes(String nome) {
		for (Usuario u : usuarios) {
			if (u.getLogin().equals(nome))
				return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

	public Usuario autenticar(String entradaL, String entradaS)
			throws UsuarioSenhaErradoException {
		Usuario usuario = null;
		for (Usuario u : usuarios)
			if (u.getLogin().equals(entradaL) && !u.getSenha().equals(entradaS) || !u.getLogin().equals(entradaL)){
				throw new UsuarioSenhaErradoException(); // Não está lançando a Exception
			}else{
					usuario = u;
					System.out.println("Usuário encontrado.\n---------------------------");
			}
		return usuario;
	}

	
	public void deletarUsuario(Usuario user){
		for (Usuario u : usuarios)
			if (u.getLogin().equals(user.getLogin())){
				usuarios.remove(u); // Não funcionou.
			}						
		System.out.println("Usuário "+user.getLogin()+" removido com sucesso.\n---------------------------");
	}
	
}


//
// public String getLogin(int usuario) {
// return this.arrayDeLogin[usuario].login;
// }
//
// // public void setLogin(String login, String usuario) {
// // this.arrayDeLogin[usuario].login = login; // Não entendi o erro
// // }
//
// public String getSenha() {
// return senha;
// }
//
// public void setSenha(String senha) {
// this.senha = senha;
// }
//
// public void novoLogin(int numLog, String entradaL) {
// if (numLog < 51) {
// this.arrayDeLogin[numLog] = new Usuario();
// this.arrayDeLogin[numLog].login = entradaL;
// }
// }
//
// public void novoLoginSenha(int numLog, String entradaS) {
// arrayDeLogin[numLog].senha = entradaS;
// }
//
// public int digitarUsuarioLogin(String entradaL, int numLog) {
// for (int i = 0; i < numLog; i++) {
// if (this.arrayDeLogin[i].login.equals(entradaL)) {
// return i;
// }
// }
// return -1;
//
// }
//
// public boolean digitarSenhaLogin(int i, String entradaS) {
// if (this.arrayDeLogin[i].senha.equals(entradaS)) {
// return true;
// }
// return false;
// }
//
// public void deletarUsuario(int usuario) {
// Usuario[] arrayAux = new Usuario[50];
// this.arrayDeLogin[usuario] = null;
// for (int j = 0; j < 50; j++) {
// int ind = 0;
// if (arrayDeLogin[j] != null) {
// arrayAux[ind] = arrayDeLogin[j];
// ind++;
// }
// this.arrayDeLogin = arrayAux;
// }
// }
//
// }
