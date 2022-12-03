package model.factorys;

import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;

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
}
