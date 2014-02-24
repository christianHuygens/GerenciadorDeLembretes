package ifrn.poo.projetoLembretes;

public class Login {

	private Login[] arrayDeLogin = new Login[50];
	private String login;
	private String senha;
	
		
	
	public String getLogin(int usuario) {
		return this.arrayDeLogin[usuario].login;
	}
//	public void setLogin(String login, String usuario) {
//		this.arrayDeLogin[usuario].login = login; // Não entendi o erro
//	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void novoLogin(int numLog, String entradaL){
		if (numLog < 51){
			this.arrayDeLogin[numLog] = new Login();
			this.arrayDeLogin[numLog].login = entradaL;
		}
	}
		
		public void novoLoginSenha(int numLog, String entradaS){
				arrayDeLogin[numLog].senha = entradaS;
		}
	
	public int digitarUsuarioLogin(String entradaL, int numLog){
		for (int i = 0; i < numLog; i++){
			if (this.arrayDeLogin[i].login.equals(entradaL)){
				return i;
			}
		}
		return -1;
				
	}
			
			public boolean digitarSenhaLogin(int i, String entradaS){
				if (this.arrayDeLogin[i].senha.equals(entradaS)){
					System.out.println("Usuário encontrado.\n---------------------------");
					return true;
				}	
				return false;
			}
	
	public void deletarUsuario(int usuario){
		Login[] arrayAux = new Login[50];
		this.arrayDeLogin[usuario] = null;
		for (int j = 0; j < 50; j++){
			int ind = 0;
			if (arrayDeLogin[j] != null){
				arrayAux[ind] = arrayDeLogin[j];
				ind++;
			}
			this.arrayDeLogin = arrayAux;
		}
	}
		
	
}
