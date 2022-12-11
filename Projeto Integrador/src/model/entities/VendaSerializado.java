package model.entities;

import java.io.Serializable;

public class VendaSerializado implements Serializable{
	private int idVenda;
	
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public void setIdVenda(int id) {
		idVenda = id;
	}
	
	public int novaVenda() {
		idVenda = idVenda + 1;
		return idVenda;
	}
}
