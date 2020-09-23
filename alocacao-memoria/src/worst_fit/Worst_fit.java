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
        Processo[] Processos = new Processo[5];
        int[] memoria = new int[10];
        cargaInicial(memoria);
        
        alocacaoThread thread = new alocacaoThread();
        execucaoThread thread2 = new execucaoThread();
     
        
        
       
    }
     public static void cargaInicial(int[] memoria){
    for(int i = 0; i < memoria.length ; i++) {
      memoria[i] = -1;
    }
  }
    
}
