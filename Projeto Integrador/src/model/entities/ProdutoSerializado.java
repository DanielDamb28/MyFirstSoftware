package model.entities;

import java.io.Serializable;

public class ProdutoSerializado implements Serializable{
	
	
	private static final long serialVersionUID = 562000169887374017L;
	private int idProduto;
	
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int id) {
		idProduto = id;
	}
	
	public int novoProduto() {
		idProduto = idProduto + 1;
		return idProduto;
	}
	
}
