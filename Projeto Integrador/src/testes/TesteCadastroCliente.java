package testes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import model.entities.Cliente;
import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;

public class TesteCadastroCliente {
	
	public static void main(String args[]) throws CpfNotNull, NameNotNull {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Cliente connect = new Cliente();
		
		Instant dataCadastro = Instant.now();
		ZoneId zone = ZoneId.of("America/Edmonton");
		LocalDate cadastro = LocalDate.ofInstant(dataCadastro, zone);
		
		Cliente cliente = new Cliente("34145869023", "Joao", "Cafunde do Juda", "73998656958", LocalDate.parse("16-08-1996", fmt), cadastro, "80545523", "F");
		
		String result = connect.adicionaClienteNoBancoDeDados(cliente);
		
		System.out.println(result);
	}
	
}
