package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Cliente;
import model.factorys.FactoryScreens;
import view.FuncionarioClienteMenu;

public class ControllerFuncionarioClienteMenu implements ActionListener{
	
	private Cliente cliente;
	private FuncionarioClienteMenu tela;
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setFuncionarioClienteMenu(FuncionarioClienteMenu tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent evt) {
		ControllerFuncionarioMenuPrincipal controlClienteMenu = new ControllerFuncionarioMenuPrincipal();
		FactoryScreens chamaTela = new FactoryScreens();
		if(evt.getSource() == tela.getBtnVoltar()) {
			chamaTela.chamaFuncionarioTelaMenu(controlClienteMenu, tela.getContainer());
		}
		
	}
}
