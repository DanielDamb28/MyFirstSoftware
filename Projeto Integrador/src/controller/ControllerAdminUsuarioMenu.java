package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.entities.Usuario;
import model.factorys.FactoryScreens;
import view.AdminUsuarioMenu;

public class ControllerAdminUsuarioMenu implements ActionListener{
	
	private AdminUsuarioMenu view;
	private Usuario model;
	
	public void setView(AdminUsuarioMenu view) {
		this.view = view;
	}
	
	public void setModel(Usuario model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		FactoryScreens chamaTela = new FactoryScreens();
		
		ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
		
	    if (evt.getSource() == view.getBtnExcluirUsuario()) {
	        JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de excluir usuario");
	    }

	    if (evt.getSource() == view.getBtnEditarUsuario()) {
	        JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de edicao usuario");
	    }

	    if (evt.getSource() == view.getBtnCadastrarUsuario()) {
	        JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para cadastro de usuario");
	    }

	    if (evt.getSource() == view.getBtnBuscarUsuario()) {
	        JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para busca de usuario");
	    }
	    if (evt.getSource() == view.getBtnVoltarMenu()) {
	    	chamaTela.chamaAdminMenuPrincipal(controlMenu, view.getContainer());
	    }
		
	}

	
}
