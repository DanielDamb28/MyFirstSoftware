package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Produto;
import model.exceptions.CategoriaNotNull;
import model.exceptions.CnpjNotNull;
import model.exceptions.CorNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.MarcaNotNull;
import model.exceptions.ModeloNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.PrecoNotNull;
import model.exceptions.SetorNotNull;
import model.exceptions.TamanhoNotNull;
import model.exceptions.TelefoneNotNull;
import model.exceptions.UnidadeNotNull;
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
			
			String txt = null;
			try {
				txt = model.procuraDados(Integer.parseInt(view.getTxtId().getText()));
			} catch (NumberFormatException | ModeloNotNull | CategoriaNotNull | MarcaNotNull | CorNotNull | SetorNotNull
					| TamanhoNotNull | PrecoNotNull | UnidadeNotNull e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view.getInfo().setText(txt);
		
		}
		else if(evt.getSource() == view.getBtnExcluirProduto()) {
			String txt = model.removeProdutoDoBancoDeDados(Integer.parseInt(view.getTxtId().getText()));
			view.getInfo().setText(txt);
		}
		
	}

}
