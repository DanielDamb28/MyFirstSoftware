package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import model.entities.Venda;
import model.factorys.FactoryScreens;
import view.InfoVenda;

public class ControllerInfoVenda implements ActionListener{
	
	private InfoVenda view;
	private Venda model;
	
	public void setView(InfoVenda view) {
		this.view = view;
	}
	public void setModel(Venda model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ControllerLancaVenda control = new ControllerLancaVenda();
		
		FactoryScreens chamaTela = new FactoryScreens();
		
		if(e.getSource() == view.getBtnRegistrarVenda()) {
			if(!view.getTxtTipoDeVenda().getText().isEmpty()) {
				LocalDate cadastro = null;
				
				Instant dataCadastro = Instant.now();
				ZoneId zone = ZoneId.of("America/Edmonton");
				cadastro = LocalDate.ofInstant(dataCadastro, zone);
				
				float preco = 0;
				String cpfCliente = "";
				String tipoVenda = "";
				
				cpfCliente = (String) view.getCbCpfCliente().getSelectedItem();
				tipoVenda = view.getTxtTipoDeVenda().getText();
				
				Venda venda = null;
				
				venda = new Venda(cadastro, preco, tipoVenda, cpfCliente);
				
				chamaTela.chamaTelaVenda(control, venda);
				view.getContainer().dispose();
			} else {
				JOptionPane.showMessageDialog(view.getContainer(), "Preencha todos os campos");
			}
		}
		
	}

}
