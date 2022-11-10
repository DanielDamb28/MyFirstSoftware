package factorys;

import screens.LoginScreen;
import screens.MenuClientesAdm;
import screens.MenuDeUsuarioAdm;
import screens.MenuDoAplicativoAdm;
import screens.MenuFornecedoresAdm;
import screens.MenuProdutosAdm;
import screens.MenuVendasAdm;
import screens.MenuClientesFunc;
import screens.MenuDoAplicativoFunc;
import screens.MenuProdutosFunc;
import screens.MenuFornecedoresFunc;
import screens.MenuVendasFunc;

public class FactoryScreens {
	
	public void chamaTelaLogin() {
		new LoginScreen();
	}
	public void chamaTelaMenuAdmin() {
		new MenuDoAplicativoAdm();
	}
	public void chamaTelaDeMenuClientes() {
		new MenuClientesAdm();
	}
	public void chamaTelaDeMenuDeUsuarios() {
		new MenuDeUsuarioAdm();
	}
	public void chamaTelaDeMenuDeFornecedor() {
		new MenuFornecedoresAdm();
	}
	public void chamaTelaDeMenuDeProduto() {
		new MenuProdutosAdm();
	}
	public void chamaTelaDeMenuDeVendas() {
		new MenuVendasAdm();
	}
	
	/*-----------------------------------*/
	
	public void chamaTelaMenuFunc() {
		new MenuDoAplicativoFunc();
	}
	public void chamaTelaDeMenuClientesFunc() {
		new MenuClientesFunc();
	}
	public void chamaTelaDeMenuProdutosFunc() {
		new MenuProdutosFunc();
	}
	public void chamaTelaDeMenuVendasFunc() {
		new MenuVendasFunc();
	}
	public void chamaTelaDeMenuFornecedoresFunc() {
		new MenuFornecedoresFunc();
	}
	
}
