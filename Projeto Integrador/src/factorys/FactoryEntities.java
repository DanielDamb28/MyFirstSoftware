package factorys;

import java.time.LocalDate;

import entities.Cliente;
import exceptions.CpfNotNull;
import exceptions.NameNotNull;

public class FactoryEntities {
	
	public static Cliente createCliente(String cpf, String nome, String endereco, String telefone, LocalDate nascimento,
	LocalDate dataCadastro, String cep, String sexo) throws CpfNotNull, NameNotNull {
		
		return new Cliente(cpf, nome, endereco, telefone, nascimento, dataCadastro, cep, sexo);
	}
}
