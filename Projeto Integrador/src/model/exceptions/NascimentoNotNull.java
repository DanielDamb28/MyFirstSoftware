package model.exceptions;

public class NascimentoNotNull extends Exception{
	public NascimentoNotNull() {
		super("Data de Nascimento Não Pode ser Null");
	}
}
