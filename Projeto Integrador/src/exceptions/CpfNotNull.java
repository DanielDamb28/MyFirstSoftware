package exceptions;

public class CpfNotNull extends Exception{
	public CpfNotNull() {
		super("CPF can not be NULL");
	}
}
