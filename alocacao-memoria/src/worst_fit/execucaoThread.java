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
    
        public execucaoThread(Processo[] Processos, int[] memoria) {
            

        this.Processos = Processos;
        this.memoria = memoria;

	}

	public void run() {
            int dur = 0;
            int i = 0, j = 0;
            int st = 0;
            int p = 0;
            
            for(i = 0; i < Processos.length; i++) 
		{			 
			for(j = 0; j < memoria.length; j++) {
                           
                            if(memoria[j] != -1){
                                System.out.println("Passou");
                                verificaPro(memoria, Processos, i);
                                
                            }
                          
                        }
            
//                        while(true){
//			// while(Processos[i].getStatus() != 'F'){
//                          
//                          if(!filaProcesso(Processos)){
//                              break;
//                          }
//                            System.out.println("entrou exec");
//                            verificaPro(memoria, Processos, i);
//               
//                    }
                        System.out.println("saiu exec");
                     //mostraLog(memoria, Processos);      
               // i++;
    }
        
        }  
        
        private boolean filaProcesso(Processo[] Processos){
            for(int i = 0; i < Processos.length; i++) {
                if(Processos[i].getStatus() != 'F' || Processos[i].getStatus() != 'N') {
                    return true;
            }
        }
    return false;
            
        }
        
        
                         public static void verificaPro(int[] memoria, Processo[] Processos, int i){
                             int j = 0, dur = 0, durz = 0;
                         if(Processos[i].getStatus() == 'E'){
                               System.out.println("Passou verificaPro");
                                if(Processos[i].getDuracao() > 0){
                                  dur = Processos[i].getDuracao() - 1;
                                  Processos[i].setDuracao(dur);
                                         }
                                if(Processos[i].getDuracao() == 0){
                                 Processos[i].setStatus('F');
                                 System.out.println("foi finalizado na exec");
                                verificaMem(memoria, Processos, i);
                                }
                  
                            }
            
                    }
                         public static void verificaMem(int[] memoria, Processo[] Processos, int i){
                            int mm = 0;
                             while(mm <= memoria.length){
                                if(memoria[mm] == i){
                                    memoria[mm] = -1;
                                    System.out.println("foi desalocado");  
                                 }
                                 mm++;     
                         }
                         }
                           public static void mostraLog(int [] memoria, Processo[] Processos){
                               int countLog = 0;
                               int countFrag = 0;
                               int countNaloc = 0;
                               for(int i = 0; i < Processos.length; i++) 
                                {
                                     if(Processos[i].getStatus() != 'P' && Processos[i].getStatus() != 'N'){
                                         countLog += 1;
                                     }
                                     else if(Processos[i].getStatus() != 'N'){
                                         countNaloc += 1;
                                     }
                                 }
                               for(int mem = 0; mem <= memoria.length; mem++){
                                   if(memoria[mem] != -1){
                                       countFrag += 1;
                                   }
                               }
                               System.out.println("Processos executados: " + countLog);
                               System.out.println("Processos descartados: " + countNaloc);
                               System.out.println("Fragmentacao: " + countFrag/1024);
              
          }
                           public static void mostraMem(int[] memoria, Processo[] Processos){
                                for(int j = 0; j < memoria.length; j++) {
                            if(memoria[j] == -1){
                           System.out.println(memoria[j]);                           }else{
                             System.out.println(memoria[j] + "" + (Processos[memoria[j]].getStatus()));
                             }
                               
                           
                        }
                           }
        
}
        

