package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.factorys.FactoryScreens;

public class ControllerAdminUsuarioMenu implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		FactoryScreens chamaTela = new FactoryScreens();
		
	    if (evt.getSource() == btnExcluirUsuario) {
	        JOptionPane.showMessageDialog(this, "Trocar tela para tela de excluir usuario");
	    }

	    if (evt.getSource() == btnEditarUsuario) {
	        JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao usuario");
	    }

	    if (evt.getSource() == btnCadastrarUsuario) {
	        JOptionPane.showMessageDialog(this, "Trocar tela para cadastro de usuario");
	    }

	    if (evt.getSource() == btnBuscarUsuario) {
	        JOptionPane.showMessageDialog(this, "Trocar tela para busca de usuario");
	    }
	    if (evt.getSource() == btnVoltarMenu) {
	    	chamaTela.chamaTelaMenuAdmin();
	    	this.dispose();
	    }
		@O
		
	}

	
}
