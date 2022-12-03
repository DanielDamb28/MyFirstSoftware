package model.exceptions;

public class CpfNotNull extends Exception{
	public CpfNotNull() {
		super("CPF não pode ser nulo");
	}
}
