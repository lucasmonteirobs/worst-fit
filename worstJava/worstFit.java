package worstJava;

import java.util.ArrayList;

public class worstFit {

//private static ArrayList<Memoria> MemoriaLIDA = new ArrayList<Memoria>(1024);
static ArrayList<Processo> Processos = new ArrayList<Processo>(200);
static int[] memoria = new int[1024];


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	alocacaoThread athread = new alocacaoThread(Processos);
	execucaoThread eThread = new execucaoThread();	
	
	
	}


}
