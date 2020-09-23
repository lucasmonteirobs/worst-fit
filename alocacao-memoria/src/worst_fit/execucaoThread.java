/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worst_fit;

/**
 *
 * @author jpedr
 */
import java.util.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class execucaoThread extends Thread {
        
    private Processo[] Processos;
    private int [] memoria;
    
        public execucaoThread(/*int id, int tamanho, int duracao, char status,*/ Processo[] Processos, int[] memoria) {
            
        //this.id = id;
	//this.tamanho = tamanho;
	//this.duracao = duracao;
	//this.status = status;
        this.Processos = Processos;
        //this.memoria = memoria;
            start();
	}

	public void run() {
            int dur = 0;
            int durz = 0;
            int i = 0;
            for(i = 0; i < Processos.length; i++) 
		{			 
			for(int j = 0; j < memoria.length; j++) {
                            
                            if((memoria[j] != -1) && (Processos[i].getStatus() == 'E')){
                                
                                if(Processos[i].getDuracao() > 0){
                                  dur = Processos[i].getDuracao() - 1;
                                  Processos[i].setDuracao(dur);
                                         }else{
                                    Processos[i].setDuracao(durz);
                                }
                                System.out.println(Processos[i].getId() + " " + Processos[i].getTamanho() + " " + Processos[i].getStatus() + " " + Processos[i].getDuracao());
                             Processos[i].setStatus('F');
                            }
                            
                            if(Processos[i].getStatus() == 'F'){
                                memoria[j] = -1;
                                
                            }
                    }
                }
		
	}
}
