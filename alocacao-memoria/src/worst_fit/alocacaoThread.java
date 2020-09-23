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
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class alocacaoThread extends Thread {
    
  //  private int id;
  //  private int tamanho;
  // private int duracao;
  //  private char status;
    private Processo[] Processos;
    private int[] memoria;
    
    
	public alocacaoThread(/*int id, int tamanho, int duracao, char status,*/ Processo[] Processos, int[] memoria) {
            
        //this.id = id;
	//this.tamanho = tamanho;
	//this.duracao = duracao;
	//this.status = status;
        this.Processos = Processos;
        this.memoria = memoria;
            
	}
	
	public void run() {
		
        int count = 0;
	int countM = 0;
	int countAux = 0;
        int maiorPri = 0;
        int countNaloc = 0;
      //  int P = 0;
		for(int i = 0; i < Processos.length; i++) 
		{			 
			for(int j = 0; j < memoria.length; j++) {
                            
                            if(Processos[i].getTamanho() > memoria.length){
                                //processo nao pode ser alocado
                                countNaloc =+ 1;
                                Processos[i].setStatus('N');
                            }
                            
                            if((memoria[j] == -1) && (Processos[i].getStatus() == 'P')){
                                int auxJ = j;//passa a posição inicial da partição
                                while(memoria[auxJ] == -1) //conta o tamanho da partição
                                {
                                    countM =+ 1;
                                    auxJ++;							
				}
                                if (countM > count) //verifica qual maior partição
                                {
                                    countAux = countM;
                                    maiorPri = j;//primeira posicao da maior partição
                                    count = countAux;
                                }
                                if(Processos[i].getTamanho() <= countAux ) {//verifica se o processo cabe
						//memoriaAux[] = memoria[]; 
                                                int maiorUlt = maiorPri + j;//diz qual é a ultima posicao da partição do vetor
                                                for(int m = j; m <= maiorUlt; m++ ){//for que associa o valor do id as posições da memoria
                                                   
                                                memoria[j] = Processos[i].getId();
                                                }
					}
                                else {
                                Processos[i].setStatus('N');
                            }
                            
                        }
            try {
                Thread.sleep(100);//try catch
            } catch (InterruptedException ex) {
                Logger.getLogger(alocacaoThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                           
			}
		}
		
	}
}