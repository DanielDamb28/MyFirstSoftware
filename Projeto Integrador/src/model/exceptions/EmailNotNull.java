package model.exceptions;

public class EmailNotNull extends Exception{
	public EmailNotNull() {
		super("Email can not be NULL");
	}
}
