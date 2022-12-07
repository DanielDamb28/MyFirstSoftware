package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Produto;
import model.exceptions.CnpjNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.TelefoneNotNull;
import view.AdminProdutoExcluir;

public class ControllerAdminProdutoExcluir implements ActionListener{

	private Produto model;
	private AdminProdutoExcluir view;
	
	public void setModel(Produto model) {
		this.model = model;
	}
	
	public void setViewExcluir(AdminProdutoExcluir viewCadastro) {
		this.view = viewCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnProcurarProduto()) {
			
			String txt = model.procuraDados(Integer.parseInt(view.getTxtId().getText()));
			view.getInfo().setText(txt);
		
		}
		else if(evt.getSource() == view.getBtnExcluirProduto()) {
			String txt = model.removeProdutoDoBancoDeDados(Integer.parseInt(view.getTxtId().getText()));
			view.getInfo().setText(txt);
		}
		
	}

}
