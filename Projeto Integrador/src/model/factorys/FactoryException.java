package model.factorys;

import model.exceptions.CnpjNotNull;
import model.exceptions.CpfNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import model.exceptions.TelefoneNotNull;

public class FactoryException {
	
	public static String callNameNotNull() throws NameNotNull{
		throw new NameNotNull();
	}
	public static String callCpfNotNull() throws CpfNotNull{
		throw new CpfNotNull();
	}
	public static String callSexoNotNull() throws SexoNotNull{
		throw new SexoNotNull();
	}
	public static String callNascimentoNotNull() throws NascimentoNotNull{
		throw new NascimentoNotNull();
	}
	public static String callTelefoneNotNull() throws TelefoneNotNull {
		throw new TelefoneNotNull(); 
	}
	public static String callEmailNotNull() throws EmailNotNull {
		throw new EmailNotNull(); 
	}
	public static String callCnpjNotNUll() throws CnpjNotNull {
		throw new CnpjNotNull(); 
	}
}
