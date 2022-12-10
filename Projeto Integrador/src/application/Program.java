package application;

import controller.ControllerLogin;
import model.entities.Deserializar;
import model.entities.ItemsSerializados;
import model.entities.Login;
import model.entities.Produto;
import model.entities.Venda;
import model.factorys.FactoryScreens;
import view.TelaLogin;

public class Program {
	
	public static void main(String[] args) {
		
		Deserializar d = new Deserializar();
		ItemsSerializados item = new ItemsSerializados();
		
		try {
			item = (ItemsSerializados) d.deserializar("./id.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Produto.setIds(item.getIdProduto());
		Venda.setIds(item.getIdVenda());
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		Login login = new Login();
		
		ControllerLogin ctrl = new ControllerLogin();
		
		TelaLogin screen = new TelaLogin(ctrl);
		
		ctrl.setTelaLogin(screen);
		ctrl.setLogin(login);
		
		
	}

}
