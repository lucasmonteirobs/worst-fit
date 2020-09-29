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
public class Processo {
        private int id;
	private int tamanho = 0;
	private int duracao = 0;
	private char status;
        private int[] memoria;
        
    public Processo(int id, char status, int tamanho, int duracao) {
    this.id = id;
    this.status = status;
    this.tamanho = tamanho;
    this.duracao = duracao;

  }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

    public int[] getMemoria() {
        return memoria;
    }

    public void setMemoria(int[] memoria) {
        this.memoria = memoria;
    }
    
}
