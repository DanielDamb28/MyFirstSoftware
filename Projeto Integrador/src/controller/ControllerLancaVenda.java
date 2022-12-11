package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.entities.Produto;
import model.entities.Venda;
import model.exceptions.CategoriaNotNull;
import model.exceptions.CorNotNull;
import model.exceptions.MarcaNotNull;
import model.exceptions.ModeloNotNull;
import model.exceptions.PrecoNotNull;
import model.exceptions.SetorNotNull;
import model.exceptions.TamanhoNotNull;
import model.exceptions.UnidadeNotNull;
import view.LancaVendaInfo;

public class ControllerLancaVenda implements ActionListener{

	private List<Produto> produtos;
	
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
		
		if(e.getSource() == view.getBtnAdicionar()) {
			
			produtos = null;
			
			try {
				produtos = model.retornaProdutos();
			} catch (ModeloNotNull | CategoriaNotNull | MarcaNotNull | SetorNotNull | CorNotNull | TamanhoNotNull
					| PrecoNotNull | UnidadeNotNull e1) {
				e1.printStackTrace();
			}
			
			for(Produto p: )
		}
		
	}
	

}
