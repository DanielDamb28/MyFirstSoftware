package model.factorys;

import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;

public class FactoryException {
	
	public static String callNameNotNull() throws NameNotNull{
		throw new NameNotNull();
	}
	public static String callCpfNotNull() throws CpfNotNull{
		throw new CpfNotNull();
	}

}
