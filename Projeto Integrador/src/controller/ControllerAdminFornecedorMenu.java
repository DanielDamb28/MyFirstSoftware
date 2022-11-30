package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.factorys.FactoryScreens;

public class ControllerAdminFornecedorMenu implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
    	FactoryScreens chamaTela = new FactoryScreens();
        if (evt.getSource() == btnCadastrarFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de fornecedor");
        }

        if (evt.getSource() == btnEditarFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de fornecedor");
        }

        if (evt.getSource() == btnExcluirFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para exclusao de fornecedor");
        }

        if (evt.getSource() == btnBuscarFornedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de fornecedor");
        }
        if (evt.getSource() == btnVoltarMenu) {
        	chamaTela.chamaTelaMenuAdmin();
        	this.dispose();
        }
	}

}
