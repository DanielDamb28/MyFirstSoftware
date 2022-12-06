package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.entities.Produto;
import model.factorys.FactoryScreens;
import view.AdminProdutoMenu;
	
public class ControllerAdminProdutoMenu implements ActionListener{
	
	private Produto model;
	private AdminProdutoMenu view;
	
	public void setModel(Produto model) {
		this.model = model;
	}
	public void setView(AdminProdutoMenu view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent evt) {
		FactoryScreens chamaTela = new FactoryScreens();
		
		ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
		
        if (evt.getSource() == view.getBtnCadastrarProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de cadastro de produto");
        }

        if (evt.getSource() == view.getBtnEditarProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de edicao de produto");
        }

        if (evt.getSource() == view.getBtnExcluirProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de exclusao de produto");
        }

        if(evt.getSource() == view.getBtnBuscarProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para busca de produto");
        }
        if (evt.getSource() == view.getBtnVoltarMenu()) {
        	chamaTela.chamaAdminMenuPrincipal(controlMenu, view.getContainer());
        }
		
	}

}
