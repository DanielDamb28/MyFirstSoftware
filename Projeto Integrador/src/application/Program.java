package application;

import factorys.FactoryScreens;
import screens.MenuClientesFunc;

public class Program {
	
	public static void main(String[] args) {
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		chamaTela.chamaTelaLogin();
	}

}
