package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Cliente;
import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import view.AdminClienteExclusao;

public class ControllerAdminClienteExcluir implements ActionListener{
	private Cliente model;
	private AdminClienteExclusao view;
	
	public void setModel(Cliente model) {
		this.model = model;
	}
	
	public void setViewExcluir(AdminClienteExclusao viewCadastro) {
		this.view = viewCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnProcurarCliente()) {
			try {
				String txt = model.procuraDados(view.getTxtCpfCnpj().getText());
				view.getInfo().setText(txt);
			} catch (NameNotNull | CpfNotNull | NascimentoNotNull | SexoNotNull e) {
				e.printStackTrace();
			}
		}
		else if(evt.getSource() == view.getBtnExcluirCliente()) {
			String txt = model.removeClienteDoBancoDeDados(view.getTxtCpfCnpj().getText());
			view.getInfo().setText(txt);
		}
		
	}
	
}
