package model.factorys;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.ControllerAdminClienteMenu;
import controller.ControllerAdminFornecedorMenu;
import controller.ControllerAdminMenuPrincipal;
import controller.ControllerAdminProdutoMenu;
import controller.ControllerAdminUsuarioMenu;
import controller.ControllerAdminVendaMenu;
import controller.ControllerLogin;
import view.AdminClienteFiltrar;
import view.AdminClienteMenu;
import view.AdminFornecedorMenu;
import view.AdminMenuPrincipal;
import view.AdminProdutoMenu;
import view.AdminUsuarioMenu;
import view.AdminVendaMenu;
import view.FuncionarioClienteMenu;
import view.FuncionarioFornecedorMenu;
import view.FuncionarioMenuPrincipal;
import view.FuncionarioProdutoMenu;
import view.FuncionarioVendaMenu;
import view.TelaLogin;

public class FactoryScreens {
	
	public void chamaTelaLogin(ControllerLogin ctrl, JFrame container) {
		new TelaLogin(ctrl);
		container.dispose();
	}
	
	public void chamaTelaMenuAdmin(ControllerAdminMenuPrincipal ctrl,JFrame container) {
		new AdminMenuPrincipal(ctrl);
		container.dispose();
	}
	public void chamaAdminClienteMenu(ControllerAdminClienteMenu ctrl,JFrame container) {
		new AdminClienteMenu(ctrl);
		container.dispose();
	}
	public void chamaAdminClienteFiltrar(ActionListener ctrl,JFrame container) {
		new AdminClienteFiltrar();
		container.dispose();
	}
	public void chamaAdminUsuarioMenu(ControllerAdminUsuarioMenu ctrl,JFrame container) {
		new AdminUsuarioMenu(ctrl);
		container.dispose();
	}
	public void chamaAdminFornecedorMenu(ControllerAdminFornecedorMenu ctrl,JFrame container) {
		new AdminFornecedorMenu(ctrl);
		container.dispose();
	}
	public void chamaAdminProdutoMenu(ControllerAdminProdutoMenu ctrl,JFrame container) {
		new AdminProdutoMenu(ctrl);
		container.dispose();
	}
	public void chamaAdminVendaMenu(ControllerAdminVendaMenu ctrl,JFrame container) {
		new AdminVendaMenu(ctrl);
		container.dispose();
	}
	
	/*-----------------------------------*/
	
	public void chamaFuncionarioTelaMenu(ActionListener ctrl, JFrame container) {
		new FuncionarioMenuPrincipal();
		container.dispose();
	}
	public void chamaFuncionarioClienteMenu(ActionListener ctrl,JFrame container) {
		new FuncionarioClienteMenu();
		container.dispose();
	}
	public void chamaFuncionarioProdutoMenu(ActionListener ctrl,JFrame container) {
		new FuncionarioProdutoMenu();
		container.dispose();
	}
	public void chamaFuncionarioVendaMenu(ActionListener ctrl,JFrame container) {
		new FuncionarioVendaMenu();
		container.dispose();
	}
	public void chamaFuncionarioFornecedorMenu(ActionListener ctrl,JFrame container) {
		new FuncionarioFornecedorMenu();
		container.dispose();
	}
	
}
