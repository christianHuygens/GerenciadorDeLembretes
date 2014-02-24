package ifrn.poo.projetoLembretes;
import java.util.Date;

public class Tarefas extends Notas {

	private Date expData;

	public Tarefas (String titulo, Date expData, String tag){
		this.titulo = titulo;
		this.expData = expData;
		this.tag = tag;
		this.dataCriação = new Date();
	}
	
	public Tarefas (String titulo, Date expData, String tag, String descricao){
		this.titulo = titulo;
		this.expData = expData;
		this.descricao = descricao;
		this.tag = tag;
		this.dataCriação = new Date();
	}
	
	public Tarefas (String titulo, Date expData, String tag, String descricao, String local){
		this.titulo = titulo;
		this.expData = expData;
		this.descricao = descricao;
		this.tag = tag;
		this.local = local;
		this.dataCriação = new Date();
	}

	public Date getExpData() {
		return expData;
	}

	public void setExpData(Date expData) {
		this.expData = expData;
	}
	
}
