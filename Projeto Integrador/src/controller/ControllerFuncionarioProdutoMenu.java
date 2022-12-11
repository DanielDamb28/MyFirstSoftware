package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.entities.Produto;
import model.factorys.FactoryScreens;
import view.FuncionarioProdutoMenu;

public class ControllerFuncionarioProdutoMenu implements ActionListener{
	
	private Produto produto;
	private FuncionarioProdutoMenu view;
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void setFuncionarioProdutoMenu(FuncionarioProdutoMenu view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent evt) {
		ControllerFuncionarioMenuPrincipal control= new ControllerFuncionarioMenuPrincipal();
		ControllerAdminProdutoCadastro controlCadastro = new ControllerAdminProdutoCadastro();
		ControllerAdminProdutoExcluir controlExcluir = new ControllerAdminProdutoExcluir();
		ControllerAdminProdutoFiltrar controlFiltrar = new ControllerAdminProdutoFiltrar();
		ControllerAdicionaProdutoAoEstoque controlEstoque = new ControllerAdicionaProdutoAoEstoque();
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		if (evt.getSource() == view.getBtnAdd()) {
			chamaTela.chamaAdminProdutoCadastro(controlCadastro);
        }

        
        if (evt.getSource() == view.getBtnDelete()) {
            chamaTela.chamaAdminProdutoExcluir(controlExcluir);
        }
        

        if(evt.getSource() == view.getBtnSearch()) {
        	chamaTela.chamaAdminProdutoFiltrar(controlFiltrar, view);
        }
        
        if(evt.getSource() == view.getBtnUpdate()) {
        	chamaTela.chamaAdminAdicionaProdutoAoEstoque(controlEstoque);
        }
        
        if (evt.getSource() == view.getBtnVoltar()) {
        	chamaTela.chamaFuncionarioTelaMenu(control , view.getContainer());
        }
		
	}
}
