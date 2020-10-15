import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Processos {
	
	private static final int QUANTIDADE_PROCESSO = 10;
	private static final int TEMPO_MAXIMO = 60;
	private static final int TEMPO_MINIMO = 20;
	private static final int TAMANHO_MAXIMO = 2000;
	private static final int TAMANHO_MINIMO = 200;
	
	private List<Processo> processos = new ArrayList<Processo>();
	private int maiorQtdProcessosExecutado = Main.VAZIO;
	private int menorQtdProcessosExecutado = Main.VAZIO;
	private int somaQtdProcessosExecutado = 0;
	private int qtdVezesProcessosExecutado = 0;
	private Random random = new Random();
	
	public Processos() {
		inicializaProcessos();
	}

	private void inicializaProcessos() {
		for(int id = 1; id <= QUANTIDADE_PROCESSO; id++) 
			processos.add(new Processo(id, geraValorAleatorio(TAMANHO_MAXIMO, TAMANHO_MINIMO), geraValorAleatorio(TEMPO_MAXIMO, TEMPO_MINIMO)));
	}
	
	private int geraValorAleatorio(int max, int min) {
		return random.nextInt(max-min)+min;
	}
	
	public boolean existeProcessoEmEspera() {
		for(Processo processo : processos) {
			if(processo.getStatus().equals(StatusProcessoEnum.ESPERA)) {
				return true;
			}
		}
		
		return false;
	}

	public Processo getProcessoEmEspera() {
		for(Processo processo : processos) {
			if(processo.getStatus().equals(StatusProcessoEnum.ESPERA)) {
				return processo;
			}
		}
		
		return null;
	}

	public boolean existeProcessoEmEsperaOuExecucao() {
		for(Processo processo : processos) {
			if(processo.getStatus().equals(StatusProcessoEnum.ESPERA) || processo.getStatus().equals(StatusProcessoEnum.EXECUCAO)) {
				return true;
			}
		}
		
		return false;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void registraQuantidadeProcessoExecutado(int qtdProcessoExecutado) {
		if(qtdProcessoExecutado > 0) {
			somaQtdProcessosExecutado += qtdProcessoExecutado;
			qtdVezesProcessosExecutado++;
		
			if(maiorQtdProcessosExecutado == Main.VAZIO) {
				maiorQtdProcessosExecutado = qtdProcessoExecutado;
			}
			else if(maiorQtdProcessosExecutado < qtdProcessoExecutado) {
				maiorQtdProcessosExecutado = qtdProcessoExecutado;
			}
			
			if(menorQtdProcessosExecutado == Main.VAZIO) {
				menorQtdProcessosExecutado = qtdProcessoExecutado;
			}
			else if(menorQtdProcessosExecutado > qtdProcessoExecutado) {
				menorQtdProcessosExecutado = qtdProcessoExecutado;
			}
		}
	}
	
	public int getMaiorQtdProcessosExecutado() {
		if(maiorQtdProcessosExecutado == Main.VAZIO) 
			maiorQtdProcessosExecutado = 0;
		
		return maiorQtdProcessosExecutado;
	}
	
	public int getMenorQtdProcessosExecutado() {
		if(menorQtdProcessosExecutado == Main.VAZIO) 
			menorQtdProcessosExecutado = 0;
		
		return menorQtdProcessosExecutado;
	}
	
	public int getMediaQtdProcessosExecutado() {
		if(somaQtdProcessosExecutado > 0 && qtdVezesProcessosExecutado > 0)
			return somaQtdProcessosExecutado / qtdVezesProcessosExecutado;
		
		return 0;
	}
	
	public int getQtdProcessosExecutado() {
		int qtdProcessoExecutado = 0;
		
		for(Processo processo : processos) {
			if(processo.getStatus().equals(StatusProcessoEnum.FINALIZADO)) {
				qtdProcessoExecutado++;
			}
		}
		
		return qtdProcessoExecutado;
	}
	
	public int getQtdProcessosDescartado() {
		int qtdProcessoDescartado = 0;
		
		for(Processo processo : processos) {
			if(processo.getStatus().equals(StatusProcessoEnum.DESCARTADO)) {
				qtdProcessoDescartado++;
			}
		}
		
		return qtdProcessoDescartado;
	}
	
}
