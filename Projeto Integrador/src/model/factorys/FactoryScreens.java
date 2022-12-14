package model.factorys;

import javax.swing.JFrame;

import controller.ControllerAdicionaProdutoAoEstoque;
import controller.ControllerAdminClienteCadastro;
import controller.ControllerAdminClienteExcluir;
import controller.ControllerAdminClienteFiltrar;
import controller.ControllerAdminClienteMenu;
import controller.ControllerAdminFornecedorCadastro;
import controller.ControllerAdminFornecedorExcluir;
import controller.ControllerAdminFornecedorFiltrar;
import controller.ControllerAdminFornecedorMenu;
import controller.ControllerAdminMenuPrincipal;
import controller.ControllerAdminProdutoCadastro;
import controller.ControllerAdminProdutoExcluir;
import controller.ControllerAdminProdutoFiltrar;
import controller.ControllerAdminProdutoMenu;
import controller.ControllerAdminUsuarioCadastro;
import controller.ControllerAdminUsuarioExcluir;
import controller.ControllerAdminUsuarioFiltrar;
import controller.ControllerAdminUsuarioMenu;
import controller.ControllerAdminVendaMenu;
import controller.ControllerFuncionarioClienteMenu;
import controller.ControllerFuncionarioMenuPrincipal;
import controller.ControllerFuncionarioProdutoMenu;
import controller.ControllerFuncionarioVendaMenu;
import controller.ControllerInfoVenda;
import controller.ControllerLancaVenda;
import controller.ControllerLogin;
import model.entities.Cliente;
import model.entities.Fornecedor;
import model.entities.HistoricoVendas;
import model.entities.Login;
import model.entities.Produto;
import model.entities.Usuario;
import model.entities.Venda;
import view.AdminAdicionaProdutoNoEstoque;
import view.AdminClienteCadastro;
import view.AdminClienteExclusao;
import view.AdminClienteFiltrar;
import view.AdminClienteMenu;
import view.AdminFornecedorCadastro;
import view.AdminFornecedorExcluir;
import view.AdminFornecedorFiltrar;
import view.AdminFornecedorMenu;
import view.AdminMenuPrincipal;
import view.AdminProdutoCadastro;
import view.AdminProdutoExcluir;
import view.AdminProdutoFiltrar;
import view.AdminProdutoMenu;
import view.AdminUsuarioCadastro;
import view.AdminUsuarioExcluir;
import view.AdminUsuarioFiltrar;
import view.AdminUsuarioMenu;
import view.AdminVendaMenu;
import view.FuncionarioClienteMenu;
import view.FuncionarioMenuPrincipal;
import view.FuncionarioProdutoMenu;
import view.FuncionarioVendaMenu;
import view.HistoricoDeVendas;
import view.InfoVenda;
import view.LancaVendaInfo;
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
	
	public void chamaAdminClienteFiltrar(ControllerAdminClienteFiltrar ctrl,AdminClienteMenu view) {
		AdminClienteFiltrar tela = new AdminClienteFiltrar(ctrl);
		Cliente cliente = new Cliente();
		ctrl.setModel(cliente);
		ctrl.setViewAdmin(view);
		ctrl.setClienteFiltrar(tela);
	}
	
	public void chamaAdminClienteFiltrar(ControllerAdminClienteFiltrar ctrl,FuncionarioClienteMenu view) {
		AdminClienteFiltrar tela = new AdminClienteFiltrar(ctrl);
		Cliente cliente = new Cliente();
		ctrl.setModel(cliente);
		ctrl.setViewFuncionario(view);
		ctrl.setClienteFiltrar(tela);
	}
	
	public void chamaAdminClienteCadastro(ControllerAdminClienteCadastro ctrl) {
		AdminClienteCadastro tela = new AdminClienteCadastro(ctrl);
		Cliente cliente = new Cliente();
		ctrl.setModel(cliente);
		ctrl.setViewCadastro(tela);
	}
	
	public void chamaAdminClienteExclusao(ControllerAdminClienteExcluir ctrl) {
		AdminClienteExclusao tela = new AdminClienteExclusao(ctrl);
		Cliente cliente = new Cliente();
		ctrl.setModel(cliente);
		ctrl.setViewExcluir(tela);
	}
	
	public void chamaAdminUsuarioMenu(ControllerAdminUsuarioMenu ctrl,JFrame container) {
		AdminUsuarioMenu tela = new AdminUsuarioMenu(ctrl);
		Usuario usuario = new Usuario();
		ctrl.setModel(usuario);
		ctrl.setView(tela);
		container.dispose();
	}
	
	public void chamaAdminUsuarioCadastro(ControllerAdminUsuarioCadastro ctrl) {
		AdminUsuarioCadastro tela = new AdminUsuarioCadastro(ctrl);
		Usuario model = new Usuario();
		ctrl.setModel(model);
		ctrl.setView(tela);
	}
	
	public void chamaAdminUsuarioFiltrar(ControllerAdminUsuarioFiltrar ctrl, AdminUsuarioMenu viewMenu) {
		AdminUsuarioFiltrar tela = new AdminUsuarioFiltrar(ctrl);
		Usuario model = new Usuario();
		ctrl.setModel(model);
		ctrl.setView(tela);
		ctrl.setViewMenu(viewMenu);
	}
	public void chamaAdminUsuarioExcluir(ControllerAdminUsuarioExcluir ctrl) {
		AdminUsuarioExcluir tela = new AdminUsuarioExcluir(ctrl);
		Usuario model = new Usuario();
		ctrl.setModel(model);
		ctrl.setViewExcluir(tela);
	}
	public void chamaAdminFornecedorMenu(ControllerAdminFornecedorMenu ctrl,JFrame container) {
		AdminFornecedorMenu tela = new AdminFornecedorMenu(ctrl);
		Fornecedor fornecedor = new Fornecedor();
		ctrl.setModel(fornecedor);
		ctrl.setView(tela);
		container.dispose();
	}
	
	public void chamaAdminFornecedorCadastro(ControllerAdminFornecedorCadastro ctrl) {
		AdminFornecedorCadastro tela = new AdminFornecedorCadastro(ctrl);
		Fornecedor fornecedor = new Fornecedor();
		ctrl.setModel(fornecedor);
		ctrl.setViewCadastro(tela);
	}
	
	public void chamaAdminFornecedorFiltrar(ControllerAdminFornecedorFiltrar ctrl,AdminFornecedorMenu view) {
		AdminFornecedorFiltrar tela = new AdminFornecedorFiltrar(ctrl);
		Fornecedor fornecedor = new Fornecedor();
		ctrl.setModel(fornecedor);
		ctrl.setView(view);
		ctrl.setClienteFiltrar(tela);
	}
	
	public void chamaAdminFornecedorExcluir(ControllerAdminFornecedorExcluir ctrl) {
		AdminFornecedorExcluir tela = new AdminFornecedorExcluir(ctrl);
		Fornecedor fornecedor = new Fornecedor();
		ctrl.setModel(fornecedor);
		ctrl.setViewExcluir(tela);
	}
	
	public void chamaAdminProdutoMenu(ControllerAdminProdutoMenu ctrl,JFrame container) {
		AdminProdutoMenu tela = new AdminProdutoMenu(ctrl);
		Produto product = new Produto();
		ctrl.setModel(product);
		ctrl.setView(tela);
		container.dispose();
	}
	
	public void chamaAdminProdutoCadastro(ControllerAdminProdutoCadastro ctrl) {
		AdminProdutoCadastro tela = new AdminProdutoCadastro(ctrl);
		Produto product = new Produto();
		Fornecedor fornecedor = new Fornecedor();
		tela.setComboBox(fornecedor.retornaCnpjs());
		ctrl.setModel(product);
		ctrl.setView(tela);
	}
	
	public void chamaAdminProdutoFiltrar(ControllerAdminProdutoFiltrar ctrl, AdminProdutoMenu viewMenu) {
		AdminProdutoFiltrar tela = new AdminProdutoFiltrar(ctrl);
		Produto product = new Produto();
		ctrl.setModel(product);
		ctrl.setView(tela);
		ctrl.setViewMenuAdmin(viewMenu);
	}
	
	public void chamaAdminProdutoFiltrar(ControllerAdminProdutoFiltrar ctrl, FuncionarioProdutoMenu viewMenu) {
		AdminProdutoFiltrar tela = new AdminProdutoFiltrar(ctrl);
		Produto product = new Produto();
		ctrl.setModel(product);
		ctrl.setView(tela);
		ctrl.setViewMenuFuncionario(viewMenu);
	}
	
	public void chamaAdminProdutoExcluir(ControllerAdminProdutoExcluir ctrl) {
		AdminProdutoExcluir tela = new AdminProdutoExcluir(ctrl);
		Produto product = new Produto();
		ctrl.setViewExcluir(tela);
		ctrl.setModel(product);
	}
	
	public void chamaAdminAdicionaProdutoAoEstoque(ControllerAdicionaProdutoAoEstoque ctrl) {
		AdminAdicionaProdutoNoEstoque tela = new AdminAdicionaProdutoNoEstoque(ctrl);
		Produto produto = new Produto();
		ctrl.setModel(produto);
		ctrl.setViewCadastro(tela);
	}
	
	public void chamaAdminVendaMenu(ControllerAdminVendaMenu ctrl,JFrame container) {
		AdminVendaMenu tela = new AdminVendaMenu(ctrl);
		Venda venda = new Venda();
		ctrl.setModel(venda);
		ctrl.setView(tela);
		container.dispose();
	}
	
	public void chamaAdminVendaInfo(ControllerInfoVenda ctrl) {
		InfoVenda tela = new InfoVenda(ctrl);
		Venda venda = new Venda();
		Cliente cliente = new Cliente();
		tela.setComboBox(cliente.retornaCpfCnpj());
		ctrl.setModel(venda);
		ctrl.setView(tela);
	}
	
	public void chamaTelaVenda(ControllerLancaVenda ctrl, Venda model) {
		LancaVendaInfo tela = new LancaVendaInfo(ctrl);
		ctrl.setModel(model);
		ctrl.setView(tela);
	}
	
	public void chamaHistoricoDeVendas() {
		HistoricoDeVendas tela = new HistoricoDeVendas();
		HistoricoVendas venda = new HistoricoVendas();
		tela.fillTableWithAllDataBaseInformation(venda.retornaHistorico());
	}
	
	/*-----------------------------------*/
	
	public void chamaFuncionarioTelaMenu(ControllerFuncionarioMenuPrincipal ctrl, JFrame container) {
		FuncionarioMenuPrincipal tela = new FuncionarioMenuPrincipal(ctrl);
		ctrl.setFuncionarioMenuPrincipal(tela);
		container.dispose();
	}
	public void chamaFuncionarioClienteMenu(ControllerFuncionarioClienteMenu ctrl,JFrame container) {
		FuncionarioClienteMenu tela= new FuncionarioClienteMenu(ctrl);
		Cliente cliente = new Cliente();
		ctrl.setCliente(cliente);
		ctrl.setAdminClienteMenu(tela);
		container.dispose();
	}
	public void chamaFuncionarioProdutoMenu(ControllerFuncionarioProdutoMenu ctrl,JFrame container) {
		FuncionarioProdutoMenu tela = new FuncionarioProdutoMenu(ctrl);
		Produto product = new Produto();
		ctrl.setProduto(product);
		ctrl.setFuncionarioProdutoMenu(tela);
		container.dispose();
	}
	public void chamaFuncionarioVendaMenu(ControllerFuncionarioVendaMenu ctrl,JFrame container) {
		FuncionarioVendaMenu tela = new FuncionarioVendaMenu(ctrl);
		Venda venda = new Venda();
		ctrl.setVenda(venda);
		ctrl.setFuncionarioVendaMenu(tela);
		container.dispose();
	}
	
}
