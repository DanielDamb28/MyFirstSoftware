package factorys;

import screens.TelaLogin;
import screens.AdminClienteMenu;
import screens.AdminUsuarioMenu;
import screens.AdminMenuPrincipal;
import screens.AdminFornecedorMenu;
import screens.AdminProdutoMenu;
import screens.AdminVendaMenu;
import screens.FuncionarioClienteMenu;
import screens.FuncionarioMenuPrincipal;
import screens.FuncionarioProdutoMenu;
import screens.FuncionarioFornecedorMenu;
import screens.FuncionarioVendaMenu;

public class FactoryScreens {
	
	public void chamaTelaLogin() {
		new TelaLogin();
	}
	public void chamaTelaMenuAdmin() {
		new AdminMenuPrincipal();
	}
	public void chamaAdminMenuCliente() {
		new AdminClienteMenu();
	}
	public void chamaTelaDeMenuDeUsuarios() {
		new AdminUsuarioMenu();
	}
	public void chamaTelaDeMenuDeFornecedor() {
		new AdminFornecedorMenu();
	}
	public void chamaTelaDeMenuDeProduto() {
		new AdminProdutoMenu();
	}
	public void chamaTelaDeMenuDeVendas() {
		new AdminVendaMenu();
	}
	
	/*-----------------------------------*/
	
	public void chamaTelaMenuFunc() {
		new FuncionarioMenuPrincipal();
	}
	public void chamaTelaDeMenuClientesFunc() {
		new FuncionarioClienteMenu();
	}
	public void chamaTelaDeMenuProdutosFunc() {
		new FuncionarioProdutoMenu();
	}
	public void chamaTelaDeMenuVendasFunc() {
		new FuncionarioVendaMenu();
	}
	public void chamaTelaDeMenuFornecedoresFunc() {
		new FuncionarioFornecedorMenu();
	}
	
}
