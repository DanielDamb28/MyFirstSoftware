package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Cliente;
import model.factorys.FactoryScreens;
import view.FuncionarioClienteMenu;

public class ControllerFuncionarioClienteMenu implements ActionListener{
	
	private Cliente model;
	private FuncionarioClienteMenu viewClienteMenu;
	
	public void setCliente(Cliente model) {
		this.model = model;
	}
	
	public void setAdminClienteMenu(FuncionarioClienteMenu view) {
		this.viewClienteMenu = view;
	}

	public void actionPerformed(ActionEvent evt) {
		ControllerFuncionarioMenuPrincipal controlMenu = new ControllerFuncionarioMenuPrincipal();
		ControllerAdminClienteFiltrar controlFiltrar = new ControllerAdminClienteFiltrar();
		ControllerAdminClienteCadastro controlCadastro = new ControllerAdminClienteCadastro();
		ControllerAdminClienteExcluir controlExcluir = new ControllerAdminClienteExcluir();
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		if(evt.getSource() == viewClienteMenu.getBtnSearch()) {
			chamaTela.chamaAdminClienteFiltrar(controlFiltrar, viewClienteMenu);
		}
		if(evt.getSource() == viewClienteMenu.getBtnVoltar()) {
			chamaTela.chamaFuncionarioTelaMenu(controlMenu, viewClienteMenu.getContainer());
		}
		if(evt.getSource() == viewClienteMenu.getBtnAdd()) {
			chamaTela.chamaAdminClienteCadastro(controlCadastro);
		}
		if(evt.getSource() == viewClienteMenu.getBtnDelete()) {
			chamaTela.chamaAdminClienteExclusao(controlExcluir);
		}
	}
}
