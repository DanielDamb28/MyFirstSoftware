package model.entities;

import java.io.Serializable;

public class ItemsSerializados implements Serializable{
	

	private static final long serialVersionUID = 2833350747689481531L;
	private static int idProduto;
	private static int idVenda;
	
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int id) {
		this.idProduto = id;
	}
	
	public int novoProduto() {
		idProduto = idProduto + 1;
		return idProduto;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public void setIdVenda(int id) {
		this.idVenda = id;
	}
	
	public int novaVenda() {
		idVenda = idVenda + 1;
		return idVenda;
	}
}
