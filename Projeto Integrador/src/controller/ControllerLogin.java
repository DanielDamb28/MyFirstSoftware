package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.entities.Login;
import model.entities.Usuario;
import model.factorys.FactoryScreens;
import view.TelaLogin;

public class ControllerLogin implements ActionListener{
	
	private Login login;
	private TelaLogin telaLogin;
	
	public void setTelaLogin(TelaLogin tela) {
		telaLogin = tela;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}

	public void actionPerformed(ActionEvent event) {
		FactoryScreens chamaTela = new FactoryScreens();
		ControllerAdminMenuPrincipal controlAdmin = new ControllerAdminMenuPrincipal();
		ControllerFuncionarioMenuPrincipal controlFuncionario = new ControllerFuncionarioMenuPrincipal();
		
		if(event.getActionCommand() == "Entrar") {
			String id = telaLogin.getTxtLogin().getText();
			String senha = telaLogin.getPswSenha().getText();
			
			Usuario usuario = login.fazerLogin(id);
			if(usuario == null) {
    			JOptionPane.showMessageDialog(telaLogin.receiveContainer(), "Usuario não encontrado");
    			telaLogin.getTxtLogin().setText("");
    			telaLogin.getPswSenha().setText("");
    		}
    		else if(!senha.equals(usuario.getSenha())) {
    			JOptionPane.showMessageDialog(telaLogin.receiveContainer() ,"Senha inválida!");
    			telaLogin.getPswSenha().setText("");
    		} else {
    			System.out.println("Id: " + usuario.getId() + ", Senha: " + usuario.getSenha() + ", Tipo de Acesso: "+  usuario.getTipoAcesso());
    			if(usuario.getTipoAcesso().equals("gerente")) {
    				chamaTela.chamaAdminMenuPrincipal(controlAdmin, telaLogin.receiveContainer());
    			}
    			else if(usuario.getTipoAcesso().equals("usuario")) {
    				chamaTela.chamaFuncionarioTelaMenu(controlFuncionario, telaLogin.receiveContainer());
    			}
    		}
        }
	}

}
