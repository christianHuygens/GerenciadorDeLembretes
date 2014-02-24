package ifrn.poo.projetoLembretes;
import java.util.Date;

public abstract class Notas {

	protected String titulo;
	protected String descricao;
	protected Date dataCriação;
	protected String tag;
	protected String local;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriação() {
		return dataCriação;
	}
	public void setDataCriação(Date dataCriação) {
		this.dataCriação = dataCriação;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
}
