package model.exceptions;

public class PrecoNotNull extends Exception{

	public PrecoNotNull() {
		super("O preco do produto nao pode ser nulo");
	}
	
}
