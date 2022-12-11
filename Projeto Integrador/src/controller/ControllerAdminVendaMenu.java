package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Venda;
import model.factorys.FactoryScreens;
import view.AdminVendaMenu;

public class ControllerAdminVendaMenu implements ActionListener{
	
	private AdminVendaMenu view;
	private Venda model;
	
	public void setView(AdminVendaMenu view) {
		this.view = view;
	}
	
	public void setModel(Venda model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
		ControllerInfoVenda controlInfo = new ControllerInfoVenda();
		
		if(evt.getSource() == view.getBtnLancarVenda()) {
			chamaTela.chamaAdminVendaInfo(controlInfo);
		}
		if(evt.getSource() == view.getBtnAcessarHistorico()) {
			chamaTela.chamaHistoricoDeVendas();
		}
		if(evt.getSource() == view.getBtnVoltarMenu()) {
			chamaTela.chamaAdminMenuPrincipal(controlMenu, view.getContainer());
		}
		
	}
	
}
