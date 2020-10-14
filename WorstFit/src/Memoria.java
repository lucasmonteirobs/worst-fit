
public class Memoria { 
	
	public static final int TAMANHO_MEMORIA = 1024;
	
	private int[] memoria;
	private int maiorFragmentacao = Main.VAZIO;
	private int menorFragmentacao = Main.VAZIO;
	private int somaFragmentacao = 0;
	private int qtdFragmentacao = 0;
	private boolean esperandoMemoria;
	private Thread alocaProcesso;
	
	public Memoria() {
		inicializaMemoria();
	}

	private void inicializaMemoria() {
		memoria = new int[TAMANHO_MEMORIA];
		
		for(int i = 0; i < memoria.length; i++) {
			memoria[i] = Main.VAZIO;
		}
	}
	
	public int getMaiorEnderecoMemoriaParaAlocar(Processo processo) {
		int enderecoMemoria = Main.VAZIO;
		int tamanhoEnderecoMemoria = 0;
		
		for(int enderecoAtual = 0; enderecoAtual < memoria.length; enderecoAtual++) {
			if(memoria[enderecoAtual] == Main.VAZIO) {
				int fimEnderecoAtual;
				
				//encontra fim do espaço livre atual
				for(fimEnderecoAtual = enderecoAtual; fimEnderecoAtual < memoria.length && memoria[fimEnderecoAtual] == Main.VAZIO; fimEnderecoAtual++);
				
				int tamanhoEnderecoAtual = fimEnderecoAtual - enderecoAtual;
				
				if(tamanhoEnderecoAtual > tamanhoEnderecoMemoria) {
					enderecoMemoria = enderecoAtual;
					tamanhoEnderecoMemoria = tamanhoEnderecoAtual;
				}
				
				enderecoAtual = fimEnderecoAtual;
			}
		}
		
		return processo.getTamanho() > tamanhoEnderecoMemoria ? Main.VAZIO : enderecoMemoria;
	}
	
	public synchronized void alocaMemoria(Processo processo) {
		for(int i = processo.getEnderecoMemoria(); i < processo.getTamanho()+processo.getEnderecoMemoria(); i++) 
			memoria[i] = processo.getId();
	}
	
	public synchronized void desalocaMemoria(Processo processo) {
		for(int i = processo.getEnderecoMemoria(); i < processo.getTamanho()+processo.getEnderecoMemoria(); i++) 
			memoria[i] = Main.VAZIO;
		
		synchronized (alocaProcesso) {
			if(esperandoMemoria) {
				esperandoMemoria = false;
				try {
					alocaProcesso.notifyAll();
				} catch (Exception e) {
				}
			}
		}
	}
	
	public void imprimeMemoria() {
		int tamanhoCelula = 3;
		int qtdCelulaLinha = 32;
		int tamanhoLinha = qtdCelulaLinha * (tamanhoCelula+1)-1;
		
		imprimeLinha(tamanhoLinha);
		
		int memoriaAtual = 0;
		
		for(int i = 0; i < qtdCelulaLinha; i++) {
			System.out.print("|");
			for(int j = 0; j < qtdCelulaLinha; j++) {
				System.out.format("%3d|", memoria[memoriaAtual++]);
			}
			System.out.println();
		}
		
		imprimeLinha(tamanhoLinha);
	}
	
	private void imprimeLinha(int tamanhoLinha) {
		System.out.print("+");
		for(int i = 0; i < tamanhoLinha; i++) {
			System.out.print("=");
		}
		System.out.println("+");
	}
	
	public int getMaiorFragmentacao() {
		if(maiorFragmentacao == Main.VAZIO) 
			maiorFragmentacao = 0;
		
		return maiorFragmentacao;
	}
	
	public int getMenorFragmentacao() {
		if(menorFragmentacao == Main.VAZIO) 
			menorFragmentacao = 0;
		
		return menorFragmentacao;
	}
	
	public int getMediaFragmentacao() {
		if(qtdFragmentacao > 0 && somaFragmentacao > 0) 
			return somaFragmentacao / qtdFragmentacao;
		
		return 0;
	}

	public void registraFragmentacao() {
		int fragmentacao = calculaFragmentacao();
		
		somaFragmentacao += fragmentacao;
		qtdFragmentacao++;

		if(maiorFragmentacao == Main.VAZIO) {
			maiorFragmentacao = fragmentacao;
		}
		else if(maiorFragmentacao < fragmentacao) {
			maiorFragmentacao = fragmentacao;
		}
		
		if(menorFragmentacao == Main.VAZIO) {
			menorFragmentacao = fragmentacao;
		}
		else if(menorFragmentacao > fragmentacao) {
			menorFragmentacao = fragmentacao;
		}
		
		synchronized (alocaProcesso) {
			this.esperandoMemoria = true;
			try {
				alocaProcesso.wait();
			} catch (Exception e) {
			}
		}
		
	}

	private int calculaFragmentacao() {
		int fragmentacao = 0;
		
		for(int enderecoAtual = 0; enderecoAtual < memoria.length; enderecoAtual++) {
			if(memoria[enderecoAtual] == Main.VAZIO) {
				fragmentacao++;
			}
		}
		
		return fragmentacao;
	}
	
	public void setAlocaProcesso(Thread alocaProcesso) {
		this.alocaProcesso = alocaProcesso;
	}
	
}
