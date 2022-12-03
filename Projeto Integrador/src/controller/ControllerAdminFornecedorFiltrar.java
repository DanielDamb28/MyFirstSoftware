package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.entities.Cliente;
import model.entities.Fornecedor;
import model.exceptions.CnpjNotNull;
import model.exceptions.CpfNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import model.exceptions.TelefoneNotNull;
import view.AdminClienteFiltrar;
import view.AdminClienteMenu;
import view.AdminFornecedorFiltrar;
import view.AdminFornecedorMenu;

public class ControllerAdminFornecedorFiltrar implements ActionListener{
	private AdminFornecedorFiltrar viewFiltrar;
	private AdminFornecedorMenu viewMenu;
	private Fornecedor model;
	
	public void setClienteFiltrar(AdminFornecedorFiltrar view) {
		this.viewFiltrar = view;
	}
	
	public void setView(AdminFornecedorMenu view) {
		this.viewMenu = view;
	}
	
	public void setModel(Fornecedor fornecedor) {
		this.model = fornecedor;
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == viewFiltrar.getBtnFiltrar()) {
			if(viewFiltrar.getRbSemFiltro().isSelected()) {
				
				List<Fornecedor> fornecedores = null;
				
	        	try {
	        		fornecedores = model.retornaFornecedores();
				} catch (NameNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CnpjNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TelefoneNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmailNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				viewMenu.fillTableWithAllDataBaseInformation(fornecedores);
			}
			else if(viewFiltrar.getRbCpfCnpj().isSelected()){
				String cnpj = viewFiltrar.gettPesquisa().getText();
				List<Fornecedor> fornecedores = null;
				
	        	try {
					fornecedores = model.retornaFornecedores();
				} catch (NameNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CnpjNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TelefoneNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmailNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				viewMenu.findRowWithDataBaseInformationByCnpj(cnpj, fornecedores);
			}
			else {
				String nome = viewFiltrar.gettPesquisa().getText();
				List<Fornecedor> fornecedores = null;
				
	        	try {
					fornecedores = model.retornaFornecedores();
				} catch (NameNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CnpjNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TelefoneNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmailNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				viewMenu.findRowWithDataBaseInformationByName(nome, fornecedores);
			}
		}
		
	}
}
