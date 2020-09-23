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

	public void run(int[] memoria, Processos[] Processos) {
            
            int i = 0;
            for(i = 0; i < Processos.length; i++) 
		{			 
			for(int j = 0; j < memoria.length; j++) {
                            
                            if((memoria[j] != -1) && (Processos[i].getStatus() == 'E')){
                                
                                if(duracao > 0){
                                 Processo[i].duracao = Processo[i].duracao - 1;
                                         }else{
                                    Processo[i].duracao = 0;
                                }
                                System.out.println(Processos[i].getId + " " + Processos[i].getTamanho + " " + Processos[i].getDtatus + " " + Processos[i].getDuracao);
                             Processos[i].getStatus() == 'F'
                            }
                            
                            if(Processos[i].getStatus() == 'F'){
                                memoria[j] = -1;
                                
                            }
                    }
                }
		
	}
}
