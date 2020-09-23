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
public class Worst_fit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Processo[] Processos = new Processo[1];
        int[] memoria = new int[10];
        cargaInicialMem(memoria);
        cargaInicialPro(Processos);
        alocacaoThread[] thread = new alocacaoThread[]{new alocacaoThread(Processos, memoria)};
        execucaoThread[] thread2 = new execucaoThread[]{new execucaoThread(Processos, memoria)};
     
        
      thread[0].start();
         
       
    }
     public static void cargaInicialPro(Processo[] Processos){
         
     }
     public static void cargaInicialMem(int[] memoria){
    for(int i = 0; i < memoria.length ; i++) {
      memoria[i] = -1;
    
    }
         System.out.println("Memoria incial -1 alocada");
  }
    
}
