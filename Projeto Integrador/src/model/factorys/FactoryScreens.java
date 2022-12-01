package model.factorys;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import controller.ControllerAdminClienteFiltrar;
import controller.ControllerAdminClienteMenu;
import controller.ControllerAdminFornecedorMenu;
import controller.ControllerAdminMenuPrincipal;
import controller.ControllerAdminProdutoMenu;
import controller.ControllerAdminUsuarioMenu;
import controller.ControllerAdminVendaMenu;
import controller.ControllerLogin;
import model.entities.Cliente;
import model.entities.Fornecedor;
import model.entities.Login;
import model.entities.Produto;
import model.entities.Usuario;
import model.entities.Venda;
import view.AdminClienteCadastro;
import view.AdminClienteExclusao;
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
		Login login = new Login();
		TelaLogin tela = new TelaLogin(ctrl);
		ctrl.setLogin(login);
		ctrl.setTelaLogin(tela);
		container.dispose();
	}
	
	public void chamaAdminMenuPrincipal(ControllerAdminMenuPrincipal ctrl,JFrame container) {
		AdminMenuPrincipal tela = new AdminMenuPrincipal(ctrl);
		ctrl.setAdminMenuPrincipal(tela);
		container.dispose();
	}
	public void chamaAdminClienteMenu(ControllerAdminClienteMenu ctrl,JFrame container) {
		AdminClienteMenu tela = new AdminClienteMenu(ctrl);
		Cliente cliente = new Cliente();
		ctrl.setCliente(cliente);
		ctrl.setAdminClienteMenu(tela);
		container.dispose();
	}
	
	public void chamaAdminClienteFiltrar(ControllerAdminClienteFiltrar ctrl,DefaultTableModel model, Cliente cliente) {
		AdminClienteFiltrar tela = new AdminClienteFiltrar(ctrl);
		ctrl.setView(tela);
		ctrl.setModel(model);
		ctrl.setCliente(cliente);
	}
	
	public void chamaAdminClienteCadastro(ControllerAdminClienteMenu ctrl) {
		AdminClienteCadastro tela = new AdminClienteCadastro(ctrl);
		
	}
	
	public void chamaAdminClienteExclusao(ControllerAdminClienteMenu ctrl) {
		AdminClienteExclusao tela = new AdminClienteExclusao(ctrl);
	}
	
	public void chamaAdminUsuarioMenu(ControllerAdminUsuarioMenu ctrl,JFrame container) {
		AdminUsuarioMenu tela = new AdminUsuarioMenu(ctrl);
		Usuario usuario = new Usuario();
		ctrl.setModel(usuario);
		ctrl.setView(tela);
		container.dispose();
	}
	public void chamaAdminFornecedorMenu(ControllerAdminFornecedorMenu ctrl,JFrame container) {
		AdminFornecedorMenu tela = new AdminFornecedorMenu(ctrl);
		Fornecedor fornecedor = new Fornecedor();
		ctrl.setModel(fornecedor);
		ctrl.setView(tela);
		container.dispose();
	}
	public void chamaAdminProdutoMenu(ControllerAdminProdutoMenu ctrl,JFrame container) {
		AdminProdutoMenu tela = new AdminProdutoMenu(ctrl);
		Produto product = new Produto();
		ctrl.setModel(product);
		ctrl.setView(tela);
		container.dispose();
	}
	public void chamaAdminVendaMenu(ControllerAdminVendaMenu ctrl,JFrame container) {
		AdminVendaMenu tela = new AdminVendaMenu(ctrl);
		Venda venda = new Venda();
		ctrl.setModel(venda);
		ctrl.setView(tela);
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
