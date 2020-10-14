
public class Processo {
	
	private int id;
	private int tamanho;
	private int tempo;
	private int enderecoMemoria;
	private StatusProcessoEnum status;
	
	public Processo(int id, int tamanho, int tempo) {
		this.id = id;
		this.tamanho = tamanho;
		this.tempo = tempo;
		status = StatusProcessoEnum.ESPERA;
	}
	
	public StatusProcessoEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusProcessoEnum status) {
		this.status = status;
	}
	
	public int getTempo() {
		return tempo;
	}

	public void decrementaTempo() {
		tempo--;
	}
	
	public boolean isFinalizado() {
		return tempo <= 0;
	}
	
	public void setEnderecoMemoria(int enderecoMemoria) {
		this.enderecoMemoria = enderecoMemoria;
	}
	
	public int getEnderecoMemoria() {
		return enderecoMemoria;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public int getId() {
		return id;
	}
}
