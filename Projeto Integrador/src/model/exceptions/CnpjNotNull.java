package model.exceptions;

public class CnpjNotNull extends Exception{
	public CnpjNotNull() {
		super("CNPJ can not be NULL");
	}
}
