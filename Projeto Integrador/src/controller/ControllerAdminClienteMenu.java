package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Cliente;
import model.factorys.FactoryScreens;
import view.AdminClienteFiltrar;
import view.AdminClienteMenu;

public class ControllerAdminClienteMenu implements ActionListener{
	
	private Cliente model;
	private AdminClienteMenu viewClienteMenu;
	private AdminClienteFiltrar viewClienteFiltrar;
	
	public void setCliente(Cliente model) {
		this.model = model;
	}
	
	public void setAdminClienteMenu(AdminClienteMenu view) {
		this.viewClienteMenu = view;
	}
	
	public void setAdminClienteFiltrar(AdminClienteFiltrar view) {
		this.viewClienteFiltrar = view;
	}
	
	public void actionPerformed(ActionEvent evt) {
		ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
		ControllerAdminClienteMenu controlCliente = new ControllerAdminClienteMenu();
		ControllerAdminClienteFiltrar controlFiltrar = new ControllerAdminClienteFiltrar();
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		if(evt.getSource() == viewClienteMenu.getBtnSearch()) {
			chamaTela.chamaAdminClienteFiltrar(controlFiltrar, viewClienteMenu);
		}
		if(evt.getSource() == viewClienteMenu.getBtnVoltar()) {
			chamaTela.chamaAdminMenuPrincipal(controlMenu, viewClienteMenu.getContainer());
		}
		if(evt.getSource() == viewClienteMenu.getBtnAdd()) {
			chamaTela.chamaAdminClienteCadastro(viewClienteMenu.getController());
		}
		if(evt.getSource() == viewClienteMenu.getBtnDelete()) {
			chamaTela.chamaAdminClienteExclusao(viewClienteMenu.getController());
		}
	}
}

