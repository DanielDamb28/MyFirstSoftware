package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Produto;
import model.entities.Usuario;
import view.AdminProdutoCadastro;
import view.AdminUsuarioCadastro;

public class ControllerAdminUsuarioCadastro implements ActionListener{

	private AdminUsuarioCadastro view;
	private Usuario model;
	
	public void setView(AdminUsuarioCadastro view) {
		this.view = view;
	}

	public void setModel(Usuario model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnCadastrarUsuario()) {
			
			String id = "";
			String senha = "";
			String tipoAcesso = "";
			
			id = view.getTxtId().getText();
			senha = view.getPswSenha().getText();
			if(view.getRbUsuario().isSelected()) {
				tipoAcesso = "usuario";
			} else {
				tipoAcesso = "gerente";
			}
			
			Usuario user = null;
			
			try {
				user = new Usuario(id, senha, tipoAcesso);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			String result = model.adicionaUsuarioNoBancoDeDados(user);
			
			System.out.println(result);
			
		}
		
	}

}
