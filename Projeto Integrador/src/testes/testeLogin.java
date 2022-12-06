package testes;

import model.entities.Login;
import model.entities.Usuario;

public class testeLogin {
	public static void main(String args[]) {
		
		Login login = new Login();
		String id = "FUNC";
		String senha = "func";
		
		Usuario usuario = login.fazerLogin(id);
		if(usuario == null) {
			System.out.println("Usuario não encontrado");
		}
		else if(!senha.equals(usuario.getSenha())) {
			System.out.println("Senha inválida!");
		} else {
			System.out.println("Id: " + usuario.getId() + ", Senha: " + usuario.getSenha() + ", Tipo de Acesso: "+  usuario.getTipoAcesso());
		}
		
		
	}
}
