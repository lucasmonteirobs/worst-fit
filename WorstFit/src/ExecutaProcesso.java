public class ExecutaProcesso implements Runnable {

	private Processos processos;
	private Memoria memoria;

	public ExecutaProcesso(Processos processos, Memoria memoria) {
		this.processos = processos;
		this.memoria = memoria;
	}
	
	@Override
	public void run() {
		while(processos.existeProcessoEmEsperaOuExecucao()) {
			
			int qtdProcessoExecutado = 0;
			
			for(Processo processo : processos.getProcessos()) {
				if(processo.getStatus().equals(StatusProcessoEnum.EXECUCAO)) {
					processo.decrementaTempo();
					
					if(processo.isFinalizado()) {
						memoria.desalocaMemoria(processo);
						processo.setStatus(StatusProcessoEnum.FINALIZADO);
					}
					
					qtdProcessoExecutado++;
				}
			}
			
			processos.registraQuantidadeProcessoExecutado(qtdProcessoExecutado);
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			
		}
		
	}

}
