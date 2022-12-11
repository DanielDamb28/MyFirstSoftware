package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.entities.Produto;
import model.entities.Venda;
import view.LancaVendaInfo;

public class ControllerLancaVenda implements ActionListener{

	private LancaVendaInfo view;
	private Venda model;
	private Produto produto;
	
	public void setView(LancaVendaInfo view) {
		this.view = view;
	}
	public void setModel(Venda model) {
		this.model = model;
	}
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBtnPesquisar()) {
			
			System.out.println("AAAAAAAAAAAAAAAAAA");
			
			try {
				setProduto(model.procuraDados(Integer.parseInt(view.getTxtId().getText())));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view.getContainer(), "Produto não encontrado");
			}
			
			view.getTxtModelo().setText(produto.getModelo());
		}
		
	}
	

}
