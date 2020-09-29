/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worst_fit;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        final int PRO = 7;
        Processo[] Processos = new Processo[PRO];
        //Processos[0] = new Processo(0, 'P', 3, 5);
       // Processos[1] = new Processo(1, 'P', 2, 2);
        int[] memoria = new int[20];
        //alocacaoThread aloc = new alocacaoThread();
        cargaInicialMem(memoria);
        cargaInicialPro(Processos);
        alocacaoThread a = new alocacaoThread(Processos, memoria);
        execucaoThread e = new execucaoThread(Processos, memoria);
        long startTime = System.currentTimeMillis();
        for(int j = 0; j < memoria.length; j++) {
                            if(memoria[j] == -1){
                            System.out.println(memoria[j]);
                            }else{
                                System.out.println(memoria[j] + "" + (Processos[memoria[j]].getStatus()));
                                }
                                
                            
                        }
        a.start();
        e.start();
      
        try {
           
            a.join();
            e.join();
            System.out.println("Acabou");
            long endTime = System.currentTimeMillis();
            //System.out.println(a.countE);
            System.out.println("Tempo total de execucao dos processos: " + (endTime - startTime) + "ms");
            System.out.println("Tempo medio de execucao dos processos: " + (endTime - startTime)/PRO + "ms");
            for(int j = 0; j < memoria.length; j++) {
                            if(memoria[j] == -1){
                           System.out.println(memoria[j]);                           }else{
                             System.out.println(memoria[j] + "" + (Processos[memoria[j]].getStatus()));
                             }
                               
                           
                        }
        } catch (InterruptedException ex) {
            Logger.getLogger(Worst_fit.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
         
       
    
     public static void cargaInicialPro(Processo[] Processos){
         Random rand = new Random();
         for(int i = 0; i < Processos.length ; i++) {
             Processos[i] = new Processo(i ,'P', rand.nextInt(5 - 2 + 1) + 2, rand.nextInt(3 + 2 + 1) + 2);
       
         }
     }
     public static void cargaInicialMem(int[] memoria){
    for(int i = 0; i < memoria.length ; i++) {
      memoria[i] = -1;
    
    }
         System.out.println("Memoria incial -1 alocada");
  }
    
}
