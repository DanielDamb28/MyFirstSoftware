package testes;

import model.entities.Cliente;

public class TesteExcluiCliente {

	public static void main(String[] args) {
		Cliente connect = new Cliente();
		
		String cpfCnpj = "70415979118";
		
		String resposta = connect.removeClienteDoBancoDeDados(cpfCnpj);
		
		System.out.println(resposta);
	}

}
