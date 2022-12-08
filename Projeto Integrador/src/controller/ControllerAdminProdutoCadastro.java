package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Fornecedor;
import model.entities.Produto;
import view.AdminProdutoCadastro;

public class ControllerAdminProdutoCadastro implements ActionListener{
	
	
	private AdminProdutoCadastro view;
	private Produto model;
	
	public void setView(AdminProdutoCadastro view) {
		this.view = view;
	}

	public void setModel(Produto model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == view.getBtnCadastrarProduto()) {
			
			String modelo = "";
			String categoria = "";
			String marca = "";
			String setor = "";
			String cor = "";
			String tamanho = "";
			float preco = 0;
			int unidadesEstoque = 0;
			String fornecedorCnpj = "";
			
			modelo = view.getTxtModelo().getText();
			categoria = view.getTxtCategoria().getText();
			marca = view.getTxtMarca().getText();
			setor = view.getTxtSetor().getText();
			cor = view.getTxtCor().getText();
			tamanho = view.getTxtTamanho().getText();
			preco = Float.parseFloat(view.getTxtPreco().getText());
			System.out.println(preco);
			unidadesEstoque = Integer.parseInt(view.getTxtUnidades().getText());
			fornecedorCnpj = (String) view.getCnpjs().getSelectedItem();
			
			Produto product = null;
			
			try {
				product = new Produto(modelo, categoria, marca, setor, cor, tamanho, preco, unidadesEstoque, fornecedorCnpj);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			String result = model.adicionaProdutoNoBancoDeDados(product);
			
			System.out.println(result);
			
		}
		
	}
	
	
}
