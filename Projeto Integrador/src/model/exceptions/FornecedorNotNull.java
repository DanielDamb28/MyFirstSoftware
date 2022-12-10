package model.exceptions;

public class FornecedorNotNull extends Exception{

	public FornecedorNotNull() {
		super("O fornecedor do produto nao pode ser nulo"); 
	}
}
