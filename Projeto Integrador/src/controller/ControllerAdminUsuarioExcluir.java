package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Usuario;
import view.AdminUsuarioExcluir;

public class ControllerAdminUsuarioExcluir implements ActionListener{

	private Usuario model;
	private AdminUsuarioExcluir view;
	
	public void setModel(Usuario model) {
		this.model = model;
	}
	
	public void setViewExcluir(AdminUsuarioExcluir viewCadastro) {
		this.view = viewCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnProcurarUsuario()) {
			
			String txt = model.procuraDados(view.getTxtId().getText());
			view.getInfo().setText(txt);
		
		}
		else if(evt.getSource() == view.getBtnExcluirUsuario()) {
			String txt = model.removeProdutoDoBancoDeDados(view.getTxtId().getText());
			view.getInfo().setText(txt);
		}
		
	}

}
