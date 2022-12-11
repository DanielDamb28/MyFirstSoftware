package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.entities.ItensVendidos;
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

	private List<Produto> produtosAdicionados = new ArrayList<Produto>();;
	
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
			
			if(view.getTxtUnidades().getText().isEmpty()) {
				JOptionPane.showMessageDialog(view.getContainer(), "Unidades nao pode ser nulo");
			} else {
				List<Produto> produtos = null;
				
				try {
					produtos = model.retornaProdutos();
				} catch (ModeloNotNull | CategoriaNotNull | MarcaNotNull | SetorNotNull | CorNotNull | TamanhoNotNull
						| PrecoNotNull | UnidadeNotNull e1) {
					e1.printStackTrace();
				}
				
				int produtoId = Integer.parseInt(view.getTxtId().getText());
				int unidadesEstoque = Integer.parseInt(view.getTxtUnidades().getText());
				
				float precoTotal = Float.parseFloat(view.getlPrecoTotal().getText());
				
				for(Produto p: produtos) {
					if(p.getId() == produtoId) {
						if(p.getUnidadesEstoque() >= unidadesEstoque) {
							try {
								p.setUnidadesEstoque(unidadesEstoque);
							} catch (UnidadeNotNull e1) {
								e1.printStackTrace();
							}
							precoTotal += p.getPreco() * unidadesEstoque;
							model.setPrecoTotal(precoTotal);
							view.getlPrecoTotal().setText(String.valueOf(precoTotal));
							produtosAdicionados.add(p);
							
							
							view.fillTableWithAllDataBaseInformation(produtosAdicionados);
						} else {
							JOptionPane.showMessageDialog(view.getContainer(), "Não há esse tanto de unidades disponiveis");
						}
					}
				}
			}
			
		}
		
		if(e.getSource() == view.getBtnFazerVenda()) {
			
			model.adicionaVendaNoBancoDeDados(model);
			
			for(Produto p: produtosAdicionados) {
				ItensVendidos itens = null;
				
				itens = new ItensVendidos(p.getId(), model.getId(), p.getUnidadesEstoque(), p.getPreco());
				
				itens.adicionaVendaNoBancoDeDados(itens);
				
				
			}
		}
		
	}
	

}
