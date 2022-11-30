package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.factorys.FactoryScreens;

public class ControllerAdminProdutoMenu implements ActionListener{

	public void actionPerformed(ActionEvent evt) {
		FactoryScreens chamaTela = new FactoryScreens();
        if (evt.getSource() == "Cadastrar novo produto") {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de produto");
        }

        if (evt.getSource() == btnEditarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de produto");
        }

        if (evt.getSource() == btnExcluirProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de exclusao de produto");
        }

        if(evt.getSource() == btnBuscarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de produto");
        }
        if (evt.getSource() == btnVoltarMenu) {
        	chamaTela.chamaTelaMenuAdmin();
        	this.dispose();
        }
		
	}

}
