package model.exceptions; 

public class TelefoneNotNull extends Exception{
	public TelefoneNotNull() {
		super("Telefone não pode ser nulo");
	}
}
