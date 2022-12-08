package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Usuario;
import model.factorys.FactoryScreens;
import view.AdminUsuarioMenu;

public class ControllerAdminUsuarioMenu implements ActionListener{
	
	private AdminUsuarioMenu view;
	private Usuario model;
	
	public void setView(AdminUsuarioMenu view) {
		this.view = view;
	}
	
	public void setModel(Usuario model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		FactoryScreens chamaTela = new FactoryScreens();
		
		ControllerAdminMenuPrincipal controlMenu = new ControllerAdminMenuPrincipal();
		ControllerAdminUsuarioCadastro controlCadastro = new ControllerAdminUsuarioCadastro();
		ControllerAdminUsuarioFiltrar controlFiltrar = new ControllerAdminUsuarioFiltrar();
		ControllerAdminUsuarioExcluir controlExcluir = new ControllerAdminUsuarioExcluir();
		
	    if (evt.getSource() == view.getBtnDelete()) {
	        chamaTela.chamaAdminUsuarioExcluir(controlExcluir);
	    }

	    if (evt.getSource() == view.getBtnAdd()) {
	        chamaTela.chamaAdminUsuarioCadastro(controlCadastro);
	    }

	    if (evt.getSource() == view.getBtnSearch()) {
	        chamaTela.chamaAdminUsuarioFiltrar(controlFiltrar, view);
	    }
	    
	    if (evt.getSource() == view.getBtnVoltar()) {
	    	chamaTela.chamaAdminMenuPrincipal(controlMenu, view.getContainer());
	    }
		
	}

	
}
