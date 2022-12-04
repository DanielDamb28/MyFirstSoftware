package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Fornecedor;
import model.exceptions.CnpjNotNull;
import model.exceptions.CpfNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import model.exceptions.TelefoneNotNull;
import view.AdminFornecedorExcluir;

public class ControllerAdminFornecedorExcluir implements ActionListener{

	private Fornecedor model;
	private AdminFornecedorExcluir view;
	
	public void setModel(Fornecedor model) {
		this.model = model;
	}
	
	public void setViewExcluir(AdminFornecedorExcluir viewCadastro) {
		this.view = viewCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnProcurarFornecedor()) {
			try {
				String txt = model.procuraDados(view.getTxtCnpj().getText());
				view.getInfo().setText(txt);
			} catch (NameNotNull | CnpjNotNull | TelefoneNotNull | EmailNotNull e) {
				e.printStackTrace();
			}
		}
		else if(evt.getSource() == view.getBtnExcluirFornecedor()) {
			String txt = model.removeFornecedorDoBancoDeDados(view.getTxtCnpj().getText());
			view.getInfo().setText(txt);
		}
		
	}
}
