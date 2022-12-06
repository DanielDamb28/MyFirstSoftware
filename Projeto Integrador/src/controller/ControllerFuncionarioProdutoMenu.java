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
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		if (evt.getSource() == view.getBtnCadastrarProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de cadastro de produto");
        }

        if (evt.getSource() == view.getBtnEditarProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de edicao de produto");
        }

        /*
        if (evt.getSource() == view.getBtnExcluirProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para tela de exclusao de produto");
        }
        */

        if(evt.getSource() == view.getBtnBuscarProduto()) {
            JOptionPane.showMessageDialog(view.getContainer(), "Trocar tela para busca de produto");
        }
        
        
        if (evt.getSource() == view.getBtnVoltarMenu()) {
        	chamaTela.chamaFuncionarioTelaMenu(control , view.getContainer());
        }
		
	}
}
