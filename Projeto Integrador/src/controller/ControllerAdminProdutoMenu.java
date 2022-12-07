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
		ControllerAdminProdutoCadastro controlCadastro = new ControllerAdminProdutoCadastro();
		ControllerAdminProdutoFiltrar controlFiltrar = new ControllerAdminProdutoFiltrar();
		ControllerAdminProdutoExcluir controlExcluir = new ControllerAdminProdutoExcluir();
		
        if (evt.getSource() == view.getBtnAdd()) {
           chamaTela.chamaAdminProdutoCadastro(controlCadastro);
        }

        if (evt.getSource() == view.getBtnUpdate()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de edicao de produto");
        }

        if (evt.getSource() == view.getBtnDelete()) {
        	chamaTela.chamaAdminProdutoExcluir(controlExcluir);
        }

        if(evt.getSource() == view.getBtnSearch()) {
        	chamaTela.chamaAdminProdutoFiltrar(controlFiltrar, view);
        }
        if (evt.getSource() == view.getBtnVoltar()) {
        	chamaTela.chamaAdminMenuPrincipal(controlMenu, view.getContainer());
        }
		
	}

}
