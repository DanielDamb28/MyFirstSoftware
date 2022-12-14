package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.entities.Login;
import model.entities.Usuario;
import model.entities.Venda;
import model.factorys.FactoryScreens;
import view.TelaLogin;

public class ControllerLogin implements ActionListener{
	
	private Login login;
	private TelaLogin view;
	
	public void setTelaLogin(TelaLogin view) {
		this.view = view;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}

	public void actionPerformed(ActionEvent evt) {
		FactoryScreens chamaTela = new FactoryScreens();
		ControllerAdminMenuPrincipal controlAdmin = new ControllerAdminMenuPrincipal();
		ControllerFuncionarioMenuPrincipal controlFuncionario = new ControllerFuncionarioMenuPrincipal();
		
		if(evt.getSource() == view.getBtnEntrar()) {
			String id = view.getTxtLogin().getText();
			String senha = view.getPswSenha().getText();
			
			Usuario usuario = login.fazerLogin(id);
			if(usuario == null) {
    			view.mensagemUsuarioNaoEncontrado();
    			view.getTxtLogin().setText("");
    			view.getPswSenha().setText("");
    		}
    		else if(!senha.equals(usuario.getSenha())) {
    			view.mensagemSenhaInvalida();
    			view.getPswSenha().setText("");
    		} else {
    			Venda.setUsuarioX(usuario);
    			System.out.println("Id: " + usuario.getId() + ", Senha: " + usuario.getSenha() + ", Tipo de Acesso: "+  usuario.getTipoAcesso());
    			if(usuario.getTipoAcesso().equals("gerente")) {
    				chamaTela.chamaAdminMenuPrincipal(controlAdmin, view.receiveContainer());
    			}
    			else if(usuario.getTipoAcesso().equals("usuario")) {
    				chamaTela.chamaFuncionarioTelaMenu(controlFuncionario, view.receiveContainer());
    			}
	        }
        }
	}

}
