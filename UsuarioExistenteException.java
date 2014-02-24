package ifrn.poo.excecao;

public class UsuarioExistenteException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMsg() {
        return "O nome de usuário já existe no nosso banco de dados.\n---------------------------";
    }
    
}
