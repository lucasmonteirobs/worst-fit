
public class Processo {
	private Integer id;
	private Integer executando;
	private Integer alocado;
	private Integer visitado;

	Processo(Integer executando, Integer alocado, Integer visitado, Integer id) {
		this.id = id;
		this.executando = executando;
		this.alocado = alocado;
		this.visitado = visitado;
	}
	
	public Processo(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getexecutando() {
		return executando;
	}

	public void setexecutando(Integer executando) {
		this.executando = executando;
	}

	public Integer getAlocado() {
		return alocado;
	}

	public void setAlocado(Integer alocado) {
		this.alocado = alocado;
	}

	public Integer getVisitado() {
		return visitado;
	}

	public void setVisitado(Integer visitado) {
		this.visitado = visitado;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", executando=" + executando + ", alocado=" + alocado + ", visitado=" + visitado
				+ "]";
	}
}
