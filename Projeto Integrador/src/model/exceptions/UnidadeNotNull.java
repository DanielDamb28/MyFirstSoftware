package model.exceptions;

public class UnidadeNotNull extends Exception{

	public UnidadeNotNull() {
		super("As unidades do produto nao podem ser nulas");
	}
}
