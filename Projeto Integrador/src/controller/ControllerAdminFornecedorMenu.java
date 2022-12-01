package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.entities.Fornecedor;
import model.factorys.FactoryScreens;
import view.AdminFornecedorMenu;

public class ControllerAdminFornecedorMenu implements ActionListener{
	
	private Fornecedor model;
	private AdminFornecedorMenu view;
	
	public void setModel(Fornecedor model) {
		this.model = model;
	}
	
	public void setView(AdminFornecedorMenu view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();
    	
    	ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
    	
        if (evt.getSource() == view.getBtnCadastrarFornecedor()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de cadastro de fornecedor");
        }

        if (evt.getSource() == view.getBtnEditarFornecedor()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de edicao de fornecedor");
        }

        if (evt.getSource() == view.getBtnExcluirFornecedor()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para exclusao de fornecedor");
        }

        if (evt.getSource() == view.getBtnBuscarFornedor()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para busca de fornecedor");
        }
        if (evt.getSource() == view.getBtnVoltarMenu()) {
        	chamaTela.chamaAdminMenuPrincipal(controlMenu, view.getContainer());
        }
	}

}
