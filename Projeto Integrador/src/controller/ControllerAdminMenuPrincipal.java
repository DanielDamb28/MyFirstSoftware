package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Login;
import model.factorys.FactoryScreens;
import view.AdminMenuPrincipal;

public class ControllerAdminMenuPrincipal implements ActionListener{
	
	private AdminMenuPrincipal view;
	
	public void setAdminMenuPrincipal(AdminMenuPrincipal view) {
		this.view = view;
	}
	
	public void actionPerformed (ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();
    	Login conexao = new Login();
    	
    	ControllerAdminClienteMenu controlCliente = new ControllerAdminClienteMenu();
    	ControllerAdminFornecedorMenu controlFornecedor = new ControllerAdminFornecedorMenu();
    	ControllerAdminProdutoMenu controlProduto = new ControllerAdminProdutoMenu();
    	ControllerAdminUsuarioMenu controlUsuario = new ControllerAdminUsuarioMenu();
    	ControllerAdminVendaMenu controlVenda = new ControllerAdminVendaMenu();
    	ControllerLogin controlLogin = new ControllerLogin();
    	
        if (evt.getActionCommand() == "Administrar usuarios") {
            chamaTela.chamaAdminUsuarioMenu(controlUsuario, view.getContainer());
        }

        if (evt.getActionCommand() == "Clientes") {
            chamaTela.chamaAdminClienteMenu(controlCliente, view.getContainer());
        }

        if (evt.getActionCommand() == "Produtos") {
            chamaTela.chamaAdminProdutoMenu(controlProduto, view.getContainer());
        }

        if (evt.getActionCommand() == "Vendas") {
            chamaTela.chamaAdminVendaMenu(controlVenda, view.getContainer());
        }

        if (evt.getActionCommand() == "Fornecedores") {
            chamaTela.chamaAdminFornecedorMenu(controlFornecedor, view.getContainer());
        }
        
        if (evt.getActionCommand() == "Deslogar") {
        	chamaTela.chamaTelaLogin(controlLogin, view.getContainer());
        }

    }

}
