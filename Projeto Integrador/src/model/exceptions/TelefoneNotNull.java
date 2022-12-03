package model.exceptions; 

public class TelefoneNotNull extends Exception{
	public TelefoneNotNull() {
		super("Telefone can not be NULL");
	}
}
