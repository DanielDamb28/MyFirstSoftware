package model.exceptions;

public class EmailNotNull extends Exception{
	public EmailNotNull() {
		super("Email não pode ser nulo");
	}
}
