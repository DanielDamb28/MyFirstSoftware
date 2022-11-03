package testes;

import conexaopostgree.ConexaoCliente;

public class TesteExcluiCliente {

	public static void main(String[] args) {
		ConexaoCliente connect = new ConexaoCliente();
		
		String cpfCnpj = "70415979110";
		
		String resposta = connect.removeClienteDoBancoDeDados(cpfCnpj);
		
		System.out.println(resposta);
	}

}
