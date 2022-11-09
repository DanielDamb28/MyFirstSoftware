package factorys;

import screens.MenuClientesAdm;
import screens.MenuDeUsuarioAdm;
import screens.MenuDoAplicativoAdm;
import screens.MenuFornecedoresAdm;
import screens.MenuProdutosAdm;
import screens.MenuVendasAdm;

public class FactoryScreens {
	
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
}
