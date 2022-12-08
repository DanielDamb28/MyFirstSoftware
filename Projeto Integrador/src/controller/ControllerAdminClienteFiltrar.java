package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.entities.Cliente;
import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import view.AdminClienteFiltrar;
import view.AdminClienteMenu;
import view.FuncionarioClienteMenu;

public class ControllerAdminClienteFiltrar implements ActionListener{
	
	private AdminClienteFiltrar viewFiltrar;
	private FuncionarioClienteMenu viewMenuFuncionario;
	private AdminClienteMenu viewMenuAdmin;
	private Cliente model;
	
	public void setClienteFiltrar(AdminClienteFiltrar view) {
		this.viewFiltrar = view;
	}
	
	public void setViewFuncionario(FuncionarioClienteMenu view) {
		this.viewMenuFuncionario = view;
	}
	
	public void setViewAdmin(AdminClienteMenu view) {
		this.viewMenuAdmin = view;
	}
	
	public void setModel(Cliente cliente) {
		this.model = cliente;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == viewFiltrar.getBtnFiltrar()) {
			if(viewFiltrar.getRbSemFiltro().isSelected()) {
				
				List<Cliente> clientes = null;
				
	        	try {
					clientes = model.retornaClientes();
				} catch (CpfNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NameNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SexoNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NascimentoNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
	        		viewMenuAdmin.fillTableWithAllDataBaseInformation(clientes);
	        	}catch(Exception e) {
	        		viewMenuFuncionario.fillTableWithAllDataBaseInformation(clientes);
	        	}
			}
			else if(viewFiltrar.getRbCpfCnpj().isSelected()){
				String cpf = viewFiltrar.gettPesquisa().getText();
				List<Cliente> clientes = null;
				
	        	try {
					clientes = model.retornaClientes();
				} catch (CpfNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NameNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SexoNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NascimentoNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
	        		viewMenuAdmin.findRowWithDataBaseInformationByCpf(cpf, clientes);
	        	} catch(Exception e) {
	        		viewMenuFuncionario.findRowWithDataBaseInformationByCpf(cpf, clientes);
	        	}
			}
			else {
				String nome = viewFiltrar.gettPesquisa().getText();
				List<Cliente> clientes = null;
				
	        	try {
					clientes = model.retornaClientes();
				} catch (CpfNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NameNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SexoNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NascimentoNotNull e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
	        		viewMenuAdmin.findRowWithDataBaseInformationByName(nome, clientes);
	        	} catch(Exception e) {
	        		viewMenuFuncionario.findRowWithDataBaseInformationByName(nome, clientes);
	        	}
			}
		}
		
	}
	
}
