package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AdminClienteFiltrar;
import view.AdminClienteMenu;

public class ControllerAdminClienteFiltrar implements ActionListener{
	
	private AdminClienteFiltrar viewFiltrar;
	private AdminClienteMenu viewMenu;
	
	public void setClienteFiltrar(AdminClienteFiltrar view) {
		this.viewFiltrar = view;
	}
	
	public void setView(AdminClienteMenu view) {
		this.viewMenu = view;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == viewFiltrar.getBtnFiltrar()) {
			if(viewFiltrar.getRbSemFiltro().isSelected()) {
				viewMenu.fillTableWithAllDataBaseInformation();
			}
			else if(viewFiltrar.getRbCpfCnpj().isSelected()){
				String cpf = viewFiltrar.gettPesquisa().getText();
				viewMenu.findRowWithDataBaseInformationByCpf(cpf);
			}
			else {
				String nome = viewFiltrar.gettPesquisa().getText();
				viewMenu.findRowWithDataBaseInformationByName(nome);
			}
		}
		
	}
	
}
