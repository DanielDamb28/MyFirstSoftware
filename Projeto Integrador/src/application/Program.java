package application;

import factorys.FactoryScreens;

public class Program {
	
	public static void main(String[] args) {
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		chamaTela.chamaTelaLogin();
		
		//chamaTela.chamaAdminClienteFiltrar();
		
	}

}
