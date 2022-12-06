package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Venda;
import model.factorys.FactoryScreens;
import view.AdminVendaMenu;
import view.FuncionarioVendaMenu;

public class ControllerFuncionarioVendaMenu implements ActionListener{
	
	private FuncionarioVendaMenu view;
	private Venda venda;
	
	public void setFuncionarioVendaMenu(FuncionarioVendaMenu view) {
		this.view = view;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		ControllerFuncionarioMenuPrincipal controlMenu = new ControllerFuncionarioMenuPrincipal();
		
		if(evt.getSource() == view.getBtnLancarVenda()) {
			
		}
		if(evt.getSource() == view.getBtnAcessarHistorico()) {
			
		}
		if(evt.getSource() == view.getBtnVoltarMenu()) {
			chamaTela.chamaFuncionarioTelaMenu(controlMenu, view.getContainer());
		}
		
	}
	
}
