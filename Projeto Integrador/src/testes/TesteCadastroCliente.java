package testes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import conexaopostgree.ConexaoCliente;
import entities.Cliente;
import exceptions.CpfNotNull;
import exceptions.NameNotNull;
import factorys.FactoryEntities;

public class TesteCadastroCliente {
	
	public static void main(String args[]) throws CpfNotNull, NameNotNull {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		ConexaoCliente connect = new ConexaoCliente();
		
		LocalDate nascimento = LocalDate.parse("28-06-2003", fmt);
		
		Instant dataCadastro = Instant.now();
		ZoneId zone = ZoneId.of("America/Edmonton");
		LocalDate cadastro = LocalDate.ofInstant(dataCadastro, zone);
		
		Cliente cliente = FactoryEntities.createCliente("34145869023", "Joao", "Cafunde do Juda", "73998656958", LocalDate.parse("16-08-1996", fmt), cadastro, "80545523", "F");
		
		String result = connect.adicionaClienteNoBancoDeDados(cliente);
		
		System.out.println(result);
	}
	
}
