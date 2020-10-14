public class AlocaProcesso implements Runnable {

	private Processos processos;
	private Memoria memoria;

	public AlocaProcesso(Processos processos, Memoria memoria) {
		this.processos = processos;
		this.memoria = memoria;
	}
	
	@Override
	public void run() {
		while(true) {
			Processo processo = processos.getProcessoEmEspera();
			
			if(processo == null) {
				break;
			}
			
			if(Memoria.TAMANHO_MEMORIA < processo.getTamanho()) {
				System.out.println("Processo " + processo.getId() + " descartado durante a alocacao!");
				processo.setStatus(StatusProcessoEnum.DESCARTADO);
			}
			else {
				int enderecoMemoria = memoria.getMaiorEnderecoMemoriaParaAlocar(processo);
				
				if(enderecoMemoria == Main.VAZIO) {
					System.out.println("Fragmentacao durante a alocacao do processo " + processo.getId() + "!");
					memoria.registraFragmentacao();
				}
				else {
					System.out.println("Alocou processo " + processo.getId() + "!");
					processo.setEnderecoMemoria(enderecoMemoria);
					memoria.alocaMemoria(processo);
					processo.setStatus(StatusProcessoEnum.EXECUCAO);
				}
			}
			
			memoria.imprimeMemoria();
			System.out.println();
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		
	}

}
