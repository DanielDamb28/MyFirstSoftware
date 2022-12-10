package model.exceptions;

public class MarcaNotNull extends Exception{
	
	public MarcaNotNull() {
		super("A marca do produto nao pode ser nula");
	}

}
