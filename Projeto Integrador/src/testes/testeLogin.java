package testes;

import conexaopostgree.ConexaoLogin;
import entities.Usuario;

public class testeLogin {
	public static void main(String args[]) {
		
		ConexaoLogin login = new ConexaoLogin();
		
		Usuario usuario = login.fazerLogin("ADMIN", "admin");
		
		System.out.println("Id: " + usuario.getId() + ", Senha: " + usuario.getSenha() + ", Tipo de Acesso: "+  usuario.getTipoAcesso());
	}
}
