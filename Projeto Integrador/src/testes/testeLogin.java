package testes;

import conexaopostgree.ConexaoLogin;

public class testeLogin {
	public static void main(String args[]) {
		
		ConexaoLogin login = new ConexaoLogin();
		
		login.fazerLogin("ADMIN", "admin");
	}
}
