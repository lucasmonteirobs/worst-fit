
public class Main {
	
	public static final int VAZIO = -1;

	public static void main(String[] args) {
		Memoria memoria = new Memoria();
		Processos processos = new Processos();
		
		Thread alocaProcesso = new Thread(new AlocaProcesso(processos, memoria));
		
		memoria.setAlocaProcesso(alocaProcesso);
		
		Thread executaProcesso = new Thread(new ExecutaProcesso(processos, memoria));
		
		long tempoInicio = System.currentTimeMillis();
		
		alocaProcesso.start();
		executaProcesso.start();
		
		try {
			alocaProcesso.join();
			executaProcesso.join();
		} catch (Exception e) {
		}
		
		long tempoExecucaoTotal = System.currentTimeMillis() - tempoInicio;
		
		imprimeLogDeExecucao(memoria, processos, tempoExecucaoTotal);
	}

	private static void imprimeLogDeExecucao(Memoria memoria, Processos processos, long tempoExecucaoTotal) {
		System.out.println();
		System.out.println("---------- Resumo da execucao ----------");
		
		System.out.println("Quantidade de processos executados: " + processos.getQtdProcessosExecutado());
		System.out.println("Quantidade de processos descartados: " + processos.getQtdProcessosDescartado());
		
		System.out.println("Tempo de execucao total: " + tempoExecucaoTotal);
		System.out.println("Tempo medio de execucao: " + (tempoExecucaoTotal/processos.getProcessos().size()));
		
		System.out.println("Media fragmentacao: " + memoria.getMediaFragmentacao());
		System.out.println("Maior fragmentacao: " + memoria.getMaiorFragmentacao());
		System.out.println("Menor fragmentacao: " + memoria.getMenorFragmentacao());
		
		System.out.println("Media quantidade de procesos executado ao mesmo tempo: " + processos.getMediaQtdProcessosExecutado());
		System.out.println("Maior quantidade de procesos executado ao mesmo tempo: " + processos.getMaiorQtdProcessosExecutado());
		System.out.println("Menor quantidade de procesos executado ao mesmo tempo: " + processos.getMenorQtdProcessosExecutado());
	}

}
