package factorys;

import screens.AdminClienteFiltrar;
import screens.AdminClienteMenu;
import screens.AdminFornecedorMenu;
import screens.AdminMenuPrincipal;
import screens.AdminProdutoMenu;
import screens.AdminUsuarioMenu;
import screens.AdminVendaMenu;
import screens.FuncionarioClienteMenu;
import screens.FuncionarioFornecedorMenu;
import screens.FuncionarioMenuPrincipal;
import screens.FuncionarioProdutoMenu;
import screens.FuncionarioVendaMenu;
import screens.TelaLogin;

public class FactoryScreens {
	
	public void chamaTelaLogin() {
		new TelaLogin();
	}
	
	public void chamaTelaMenuAdmin() {
		new AdminMenuPrincipal();
	}
	public void chamaAdminClienteMenu() {
		new AdminClienteMenu();
	}
	public void chamaAdminClienteFiltrar() {
		new AdminClienteFiltrar();
	}
	public void chamaAdminUsuarioMenu() {
		new AdminUsuarioMenu();
	}
	public void chamaAdminFornecedorMenu() {
		new AdminFornecedorMenu();
	}
	public void chamaAdminProdutoMenu() {
		new AdminProdutoMenu();
	}
	public void chamaAdminVendaMenu() {
		new AdminVendaMenu();
	}
	
	/*-----------------------------------*/
	
	public void chamaFuncionarioTelaMenu() {
		new FuncionarioMenuPrincipal();
	}
	public void chamaFuncionarioClienteMenu() {
		new FuncionarioClienteMenu();
	}
	public void chamaFuncionarioProdutoMenu() {
		new FuncionarioProdutoMenu();
	}
	public void chamaFuncionarioVendaMenu() {
		new FuncionarioVendaMenu();
	}
	public void chamaFuncionarioFornecedorMenu() {
		new FuncionarioFornecedorMenu();
	}
	
}
