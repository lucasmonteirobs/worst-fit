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
	public int tamanho;
	public int duracao;
	public String status = 'P';
        
    public Processo(String status, int tamanho, int duracao) {
    this.status = status;
    this.tamanho = tamanho;
    this.duracao = duracao;
  }

  //  public String getStatus() {
  //      return status;
  //  }

 //   public void setStatus(String status) {
  //      this.status = status;
  //  }

	//public int getId() {
	//	return id;
	//}
	//public void setId(int id) {
	//	this.id = id;
	//}
	//public int getTamanho() {
	//	return tamanho;
	//}
	//public void setTamanho(int tamanho) {
	//	this.tamanho = tamanho;
	//}
	//public int getDuracao() {
	//	return duracao;
	//}
	//public void setDuracao(int duracao) {
	//	this.duracao = duracao;
	//}
    
}
