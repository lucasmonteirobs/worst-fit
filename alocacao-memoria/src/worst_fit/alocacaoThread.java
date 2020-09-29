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
import static worst_fit.Worst_fit.cargaInicialMem;


public class alocacaoThread extends Thread {
    

    private Processo[] Processos;
    private int[] memoria;
    
    
	public alocacaoThread(Processo[] Processos, int[] memoria) {
            

        this.Processos = Processos;
        this.memoria = memoria;
            
	}

    alocacaoThread() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public void run() {
        int auxJ;
        int count = 0;
	int countM = 0;
	int countAux = 0;
        int maiorPri = 0;
        int countNaloc = 0;
        int maiorUlt;
            

    
		for(int i = 0; i < Processos.length; i++) 
		{

                  //  System.out.println("Passei no alocacaothread verifica processo");
			for(int j = 0; j < memoria.length ; j++) {
//                            if(memoria[j] != -1){
//                                break;
//                            }
                         //   System.out.println("Passei no alocacaothread verifica memoria");
                            if(Processos[i].getTamanho() > memoria.length){
                                //processo nao pode ser alocado
                                Processos[i].setStatus('N');
                                break;
                            }
                            
                            if((memoria[j] < 0) && (Processos[i].getStatus() == 'P')){
                                auxJ = j;//passa a posição inicial da partição
                              countM = maiorPosicao(memoria, auxJ, countM);
                               
                                System.out.println(countM);
                               // System.out.println("sai do while");
                                count = 0;
                                if (countM > count) //verifica qual maior partição
                                {
                                    countAux = countM;
                                    count = countAux;
                                    maiorPri = j;//primeira posicao da maior partição
                                   // System.out.println("entrou no ifcount");
                                    
                                    System.out.println(maiorPri);
                                }
                                if(Processos[i].getTamanho() <= count ) {//verifica se o processo cabe
					
                                                maiorUlt = maiorPri + count;//diz qual é a ultima posicao da partição do vetor
                                              //   System.out.println(maiorPri + maiorUlt);
                                           
                                               int countE =  alocaId(memoria, Processos, maiorPri, maiorUlt, i);
                                              //  for(int m = maiorPri; m <= Processos[i].getTamanho(); m++ ){//for que associa o valor do id as posições da memoria
                                                   
                                              //  memoria[m] = Processos[i].getId();
                                              //  Processos[i].setStatus('E');
                                             //   System.out.println("Fui alocado");
                                //}
					}
                                else {
                                Processos[i].setStatus('N');
                               
                            }
                            countM = 0;
                            maiorUlt = 0;
                           break;
                            }
                        
                try {
                    Thread.sleep(300);//try catch
                } catch (InterruptedException ex) {
                    Logger.getLogger(alocacaoThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                           
            }
//                        for(int j = 0; j < memoria.length; j++) {
//                            if(memoria[j] == -1){
//                            System.out.println(memoria[j]);
//                            }else{
//                                System.out.println(memoria[j] + "" + (Processos[memoria[j]].getStatus()));
//                                }
//                                
//                            
//                        }
    }
    //    }            
		
}
          public static int maiorPosicao(int[] memoria, int auxJ, int countM){
    

      while(memoria[auxJ] == -1 &&  auxJ < (memoria.length - 1)) //conta o tamanho da partição
                                {
                                    countM += 1;
                                    auxJ++;
                    }
                       
              return countM;
        }
          
          
          
          public static int alocaId(int[] memoria, Processo[] Processos, int maiorPri, int maiorUlt, int i){
              
   for(int m = 0; m <= Processos[i].getTamanho(); m++ ){//for que associa o valor do id as posições da memoria
        int countE = 0;                                         
        memoria[maiorPri++] = Processos[i].getId();
        Processos[i].setStatus('E');
        countE++;
       // System.out.println("Fui alocado");
                                                }
   return countE;
    }
          
  
          
}

