package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.entities.Produto;
import model.entities.Usuario;
import view.AdminUsuarioFiltrar;
import view.AdminUsuarioMenu;

public class ControllerAdminUsuarioFiltrar implements ActionListener{
	
	private AdminUsuarioFiltrar view;
	private AdminUsuarioMenu viewMenu;
	private Usuario model;
	
	public void setView(AdminUsuarioFiltrar view) {
		this.view = view;
	}
	
	public void setViewMenu(AdminUsuarioMenu viewMenu) {
		this.viewMenu = viewMenu;
	}
	
	public void setModel(Usuario model) {
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnFiltrar()) {
			if(view.getRbSemFiltro().isSelected()) {
				
				
				List<Usuario> usuarios = null;
				
				usuarios = model.retornaUsuarios();
				
				viewMenu.fillTableWithAllDataBaseInformation(usuarios);
			}
			else if(view.getRbId().isSelected()) {
				List<Usuario> usuarios = null;
				
				usuarios = model.retornaUsuarios();
				
				viewMenu.findRowWithDataBaseInformationById(view.gettPesquisa().getText(), usuarios);
			}
			else if(view.getRbTipoAcesso().isSelected()) {
				List<Usuario> usuarios = null;
				
				usuarios = model.retornaUsuarios();
				
				viewMenu.findRowWithDataBaseInformationByTipoAcesso(view.gettPesquisa().getText(), usuarios);
			}
		
		}
	}

}
