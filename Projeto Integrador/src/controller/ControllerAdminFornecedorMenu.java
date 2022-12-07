package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    	ControllerAdminFornecedorCadastro controlCadastro = new ControllerAdminFornecedorCadastro();
    	ControllerAdminFornecedorFiltrar controlFiltrar = new ControllerAdminFornecedorFiltrar();
    	ControllerAdminFornecedorExcluir controlExcluir = new ControllerAdminFornecedorExcluir();
    	
        if (evt.getSource() == view.getBtnAdd()) {
        	chamaTela.chamaAdminFornecedorCadastro(controlCadastro);
        }
        if(evt.getSource() == view.getBtnDelete()) {
        	chamaTela.chamaAdminFornecedorExcluir(controlExcluir);
        }

        if (evt.getSource() == view.getBtnSearch()) {
            chamaTela.chamaAdminFornecedorFiltrar(controlFiltrar, view);
        }
        if (evt.getSource() == view.getBtnVoltar()) {
            chamaTela.chamaAdminMenuPrincipal(controlMenu, view);
        }
	}

}
