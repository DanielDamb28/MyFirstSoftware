package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.entities.Produto;
import model.exceptions.CategoriaNotNull;
import model.exceptions.CorNotNull;
import model.exceptions.MarcaNotNull;
import model.exceptions.ModeloNotNull;
import model.exceptions.PrecoNotNull;
import model.exceptions.SetorNotNull;
import model.exceptions.TamanhoNotNull;
import model.exceptions.UnidadeNotNull;
import view.AdminProdutoFiltrar;
import view.AdminProdutoMenu;
import view.FuncionarioProdutoMenu;

public class ControllerAdminProdutoFiltrar implements ActionListener{
	
	private AdminProdutoFiltrar view;
	private AdminProdutoMenu viewMenuAdmin;
	private FuncionarioProdutoMenu viewMenuFuncionario;
	private Produto model;
	
	public void setView(AdminProdutoFiltrar view) {
		this.view = view;
	}
	
	public void setViewMenuAdmin(AdminProdutoMenu viewMenu) {
		this.viewMenuAdmin = viewMenu;
	}
	
	public void setViewMenuFuncionario(FuncionarioProdutoMenu view) {
		this.viewMenuFuncionario = view;
	}
	
	public void setModel(Produto model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnFiltrar()) {
			if(view.getRbSemFiltro().isSelected()) {
				
				
				List<Produto> produtos = null;
				
				try {
					produtos = model.retornaProdutos();
				} catch (ModeloNotNull | CategoriaNotNull | MarcaNotNull | SetorNotNull | CorNotNull | TamanhoNotNull
						| PrecoNotNull | UnidadeNotNull e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					viewMenuAdmin.fillTableWithAllDataBaseInformation(produtos);
				}catch(Exception e) {
					viewMenuFuncionario.fillTableWithAllDataBaseInformation(produtos);
				}
			}
			else if(view.getRbModelo().isSelected()) {
				List<Produto> produtos = null;
				
				try {
					produtos = model.retornaProdutos();
				} catch (ModeloNotNull | CategoriaNotNull | MarcaNotNull | SetorNotNull | CorNotNull | TamanhoNotNull
						| PrecoNotNull | UnidadeNotNull e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					viewMenuAdmin.findRowWithDataBaseInformationByModelo(view.gettPesquisa().getText(), produtos);
				}catch(Exception e) {
					viewMenuFuncionario.findRowWithDataBaseInformationByModelo(view.gettPesquisa().getText(), produtos);
				}
			}
			else if(view.getRbMarca().isSelected()) {
				List<Produto> produtos = null;
				
				try {
					produtos = model.retornaProdutos();
				} catch (ModeloNotNull | CategoriaNotNull | MarcaNotNull | SetorNotNull | CorNotNull | TamanhoNotNull
						| PrecoNotNull | UnidadeNotNull e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					viewMenuAdmin.findRowWithDataBaseInformationByMarca(view.gettPesquisa().getText(), produtos);
				}catch(Exception e) {
					viewMenuFuncionario.findRowWithDataBaseInformationByMarca(view.gettPesquisa().getText(), produtos);
				}
			}
			else if(view.getRbTamanho().isSelected()) {
				List<Produto> produtos = null;
				
				try {
					produtos = model.retornaProdutos();
				} catch (ModeloNotNull | CategoriaNotNull | MarcaNotNull | SetorNotNull | CorNotNull | TamanhoNotNull
						| PrecoNotNull | UnidadeNotNull e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					viewMenuAdmin.findRowWithDataBaseInformationByTamanho(view.gettPesquisa().getText(), produtos);
				} catch (Exception e) {
					viewMenuFuncionario.findRowWithDataBaseInformationByTamanho(view.gettPesquisa().getText(), produtos);
				}
			}
			
			
		}
	}

}
