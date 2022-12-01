package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.entities.Cliente;
import model.factorys.FactoryScreens;
import view.AdminClienteFiltrar;
import view.AdminMenuPrincipal;

public class ControllerAdminClienteFiltrar implements ActionListener{
	
	private AdminClienteFiltrar view;
	private DefaultTableModel model;
	private Cliente cliente;
	
	public void setView(AdminClienteFiltrar view) {
		this.view = view;
	}
	
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void actionPerformed (ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();
    	
    	if(evt.getSource() == view.getBtnFiltrar()) {
    		cliente.fillTableWithDataBaseInformation(model);
    	}

    }

}
