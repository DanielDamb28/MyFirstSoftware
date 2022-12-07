package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.entities.Produto;
import view.AdminProdutoFiltrar;
import view.AdminProdutoMenu;

public class ControllerAdminProdutoFiltrar implements ActionListener{
	
	private AdminProdutoFiltrar view;
	private AdminProdutoMenu viewMenu;
	private Produto model;
	
	public void setView(AdminProdutoFiltrar view) {
		this.view = view;
	}
	
	public void setViewMenu(AdminProdutoMenu viewMenu) {
		this.viewMenu = viewMenu;
	}
	
	public void setModel(Produto model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnFiltrar()) {
			if(view.getRbSemFiltro().isSelected()) {
				
				
				List<Produto> produtos = null;
				
				produtos = model.retornaProdutos();
				
				viewMenu.fillTableWithAllDataBaseInformation(produtos);
			}
			else if(view.getRbModelo().isSelected()) {
				List<Produto> produtos = null;
				
				produtos = model.retornaProdutos();
				
				viewMenu.findRowWithDataBaseInformationByModelo(view.gettPesquisa().getText(), produtos);
			}
			else if(view.getRbMarca().isSelected()) {
				List<Produto> produtos = null;
				
				produtos = model.retornaProdutos();
				
				viewMenu.findRowWithDataBaseInformationByMarca(view.gettPesquisa().getText(), produtos);
			}
			else if(view.getRbTamanho().isSelected()) {
				List<Produto> produtos = null;
				
				produtos = model.retornaProdutos();
				
				viewMenu.findRowWithDataBaseInformationByTamanho(view.gettPesquisa().getText(), produtos);
			}
			
			
		}
	}

}
