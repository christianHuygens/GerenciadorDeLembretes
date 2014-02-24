package ifrn.poo.projetoLembretes;
import java.util.Date;

public class Lembretes extends Notas {

	public Lembretes (String titulo, String tag){
		this.titulo = titulo;
		this.tag = tag;
		this.dataCriação = new Date();
	}
	
	public Lembretes (String titulo, String tag, String descricao){
		this.titulo = titulo;
		this.tag = tag;
		this. descricao = descricao;
		this.dataCriação = new Date();
	}
	
	public Lembretes (String titulo, String tag, String descricao, String local){
		this.titulo = titulo;
		this.tag = tag;
		this. descricao = descricao;
		this. local = local;
		this.dataCriação = new Date();
	}
	
	
	
}
