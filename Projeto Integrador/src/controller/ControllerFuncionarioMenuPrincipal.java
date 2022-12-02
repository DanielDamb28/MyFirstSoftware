package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.factorys.FactoryScreens;
import view.FuncionarioMenuPrincipal;

public class ControllerFuncionarioMenuPrincipal implements ActionListener{
	
	private FuncionarioMenuPrincipal view;
	
	public void setFuncionarioMenuPrincipal(FuncionarioMenuPrincipal view) {
		this.view = view;
	}
	
	public void actionPerformed (ActionEvent evt) {
    	
    	FactoryScreens chamaTela = new FactoryScreens();
    	
    	ControllerFuncionarioClienteMenu controlCliente = new ControllerFuncionarioClienteMenu();
      	ControllerFuncionarioProdutoMenu controlProduto = new ControllerFuncionarioProdutoMenu();
    	ControllerFuncionarioVendaMenu controlVenda = new ControllerFuncionarioVendaMenu();


        if (evt.getActionCommand() == "Clientes") {
            chamaTela.chamaFuncionarioClienteMenu(controlCliente, view.getContainer());
        }

        if (evt.getActionCommand() == "Produtos") {
            chamaTela.chamaFuncionarioProdutoMenu(controlProduto, view.getContainer());
        }

        if (evt.getActionCommand() == "Vendas") {
            chamaTela.chamaFuncionarioVendaMenu(controlVenda, view.getContainer());
        }
        
        /*
        if (evt.getActionCommand() == "Deslogar") {
        	chamaTela.chamaTelaLogin(controlLogin, view.getContainer());
        }
        */
	}
}