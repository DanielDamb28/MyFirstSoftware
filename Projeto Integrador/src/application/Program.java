package application;

import controller.ControllerLogin;
import model.entities.Deserializar;
import model.entities.Login;
import model.entities.Produto;
import model.entities.ProdutoSerializado;
import model.entities.Venda;
import model.entities.VendaSerializado;
import model.factorys.FactoryScreens;
import view.TelaLogin;

public class Program {
	
	public static void main(String[] args) {
		
		Deserializar d = new Deserializar();
		ProdutoSerializado item = new ProdutoSerializado();
		VendaSerializado item2 = new VendaSerializado();
		
		try {
			item = (ProdutoSerializado) d.deserializar("./id1.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			item2 = (VendaSerializado) d.deserializar("./id2.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(item.getIdProduto());
		Produto.setIds(item.getIdProduto());
		Venda.setIds(item2.getIdVenda());
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		Login login = new Login();
		
		ControllerLogin ctrl = new ControllerLogin();
		
		TelaLogin screen = new TelaLogin(ctrl);
		
		ctrl.setTelaLogin(screen);
		ctrl.setLogin(login);
		
		
	}

}
