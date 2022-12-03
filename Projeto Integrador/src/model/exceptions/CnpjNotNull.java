package model.exceptions;

public class CnpjNotNull extends Exception{
	public CnpjNotNull() {
		super("CNPJ não pode ser nulo");
	}
}
