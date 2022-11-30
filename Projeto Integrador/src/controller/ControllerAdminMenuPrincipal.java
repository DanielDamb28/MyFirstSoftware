package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.conexao.ConexaoLogin;
import model.factorys.FactoryScreens;

public class ControllerAdminMenuPrincipal implements ActionListener{
	
	private JFrame container;
	
	public ControllerAdminMenuPrincipal(){}

	public void setContainer(JFrame container) {
		this.container = container;
	}
	
	public void actionPerformed (ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();
    	ConexaoLogin conexao = new ConexaoLogin();
    	
    	ControllerAdminClienteMenu controlCliente = new ControllerAdminClienteMenu();
    	ControllerAdminFornecedorMenu controlFornecedor = new ControllerAdminFornecedorMenu();
    	ControllerAdminProdutoMenu controlProduto = new ControllerAdminProdutoMenu();
    	ControllerAdminUsuarioMenu controlUsuario = new ControllerAdminUsuarioMenu();
    	ControllerAdminVendaMenu controlVenda = new ControllerAdminVendaMenu();
    	ControllerLogin controlLogin = new ControllerLogin(conexao);
    	
        if (evt.getActionCommand() == "Administrar usuarios") {
            chamaTela.chamaAdminUsuarioMenu(controlUsuario, container);
        }

        if (evt.getActionCommand() == "Clientes") {
            chamaTela.chamaAdminClienteMenu(controlCliente, container);
        }

        if (evt.getActionCommand() == "Produtos") {
            chamaTela.chamaAdminProdutoMenu(controlProduto, container);
        }

        if (evt.getActionCommand() == "Vendas") {
            chamaTela.chamaAdminVendaMenu(controlVenda, container);
        }

        if (evt.getActionCommand() == "Fornecedores") {
            chamaTela.chamaAdminFornecedorMenu(controlFornecedor, container);
        }
        
        if (evt.getActionCommand() == "Deslogar") {
        	chamaTela.chamaTelaLogin(controlLogin, container);
        }

    }

}
