package application;

import controller.ControllerLogin;
import model.entities.Login;
import model.factorys.FactoryScreens;
import view.TelaLogin;

public class Program {
	
	public static void main(String[] args) {
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		Login login = new Login();
		
		ControllerLogin ctrl = new ControllerLogin();
		
		TelaLogin screen = new TelaLogin(ctrl);
		
		ctrl.setTelaLogin(screen);
		ctrl.setLogin(login);
		
		//chamaTela.chamaAdminClienteFiltrar();
		
	}

}
