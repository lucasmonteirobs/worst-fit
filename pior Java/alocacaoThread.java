package worstJava;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class alocacaoThread extends Thread {

	Processo[] Processos = new Processo[2];
	
	
//	List<Processo> Processos;
//	public alocacaoThread(List<Processo> Processos) {
//	    this.Processos = Processos;
//	}
	
	public void run(List<Processo> Processos) {
		
	//int aux = 1024;
	//int i = 0;
        int count = 0;
	
					
		for(i = 0; i < Processos.size() ; i++) 
		{			 
			for(j = 0; j < memoria; j++) {
                            
                            if((memoria[j] == -1) && (Processos[i].getStatus == 'P')){
                                int auxJ = j;//passa a posição inicial da partição
                                while(memoria[auxJ] == -1) //conta o tamanho da partição
                                {
                                    int countM += 1;
                                    auxJ++;							
				}
                                if (countM > count) //verifica qual maior partição
                                {
                                    int countAux = countM;
                                    int maiorPri = j;//primeira posicao da maior partição
                                    count = countAux;
                                }
                                if(Processos[i].getTamanho <= countAux ) {//verifica se o processo esta pronto e se cabe
						//memoriaAux[] = memoria[]; 
                                                int maiorUlt = maiorPri + j;//diz qual é a ultima posicao da partição do vetor
                                                for(m = j; m <= maiorUlt; m++ ){//for que associa o valor do id as posições da memoria
                                                memoria[j] = Processos[i];
                                                }
					}
                                Processos[i] = 'E';
                            }
                            
                            
                        }
                          Thread.sleep(100);//try catch
                            
			}
		}
		
	}
