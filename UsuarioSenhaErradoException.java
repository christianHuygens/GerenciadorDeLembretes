package ifrn.poo.excecao;

public class UsuarioSenhaErradoException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMsg() {
        return "O nome de usuário ou sua senha está errado.\n---------------------------";
    }
}
