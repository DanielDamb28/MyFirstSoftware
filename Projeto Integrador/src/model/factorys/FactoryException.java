package model.factorys;

import model.exceptions.CategoriaNotNull;
import model.exceptions.CnpjNotNull;
import model.exceptions.CorNotNull;
import model.exceptions.CpfNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.FornecedorNotNull;
import model.exceptions.MarcaNotNull;
import model.exceptions.ModeloNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.PrecoNotNull;
import model.exceptions.SetorNotNull;
import model.exceptions.SexoNotNull;
import model.exceptions.TamanhoNotNull;
import model.exceptions.TelefoneNotNull;
import model.exceptions.UnidadeNotNull;

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
	public static String callCategoriaNotNUll() throws CategoriaNotNull {
		throw new CategoriaNotNull(); 
	}
	public static String callCorNotNUll() throws CorNotNull {
		throw new CorNotNull(); 
	}
	public static String callFornecedorNotNUll() throws FornecedorNotNull {
		throw new FornecedorNotNull(); 
	}
	public static String callMarcaNotNUll() throws MarcaNotNull {
		throw new MarcaNotNull(); 
	}
	public static String callModeloNotNUll() throws ModeloNotNull {
		throw new ModeloNotNull(); 
	}
	public static float callPrecoNotNUll() throws PrecoNotNull {
		throw new PrecoNotNull(); 
	}
	public static String callSetorNotNUll() throws SetorNotNull {
		throw new SetorNotNull(); 
	}
	public static String callTamanhoNotNUll() throws TamanhoNotNull {
		throw new TamanhoNotNull(); 
	}
	public static String callUnidadeNotNUll() throws UnidadeNotNull {
		throw new UnidadeNotNull(); 
	}
	
}
