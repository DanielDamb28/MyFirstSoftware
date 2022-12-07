package model.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemsSerializados implements Serializable{
	

	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int novoProduto() {
		id = id + 1;
		return id;
	}
}
