package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Cliente;
import model.factorys.FactoryScreens;
import view.AdminClienteMenu;

public class ControllerAdminClienteMenu implements ActionListener{
	
	private Cliente cliente;
	private AdminClienteMenu tela;
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setAdminClienteMenu(AdminClienteMenu tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent evt) {
		ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
		
		FactoryScreens chamaTela = new FactoryScreens();
		if(evt.getSource() == tela.getBtnVoltar()) {
			chamaTela.chamaAdminMenuPrincipal(controlMenu, tela.getContainer());
		}
		
	}
	
	
}
