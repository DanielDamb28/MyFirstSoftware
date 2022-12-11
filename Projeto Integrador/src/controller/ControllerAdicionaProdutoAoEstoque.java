package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import model.entities.Cliente;
import model.entities.Produto;
import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import view.AdminAdicionaProdutoNoEstoque;
import view.AdminClienteCadastro;
import view.AdminClienteMenu;

public class ControllerAdicionaProdutoAoEstoque implements ActionListener{
	private Produto model;
	private AdminAdicionaProdutoNoEstoque viewAdiciona;
	
	public void setModel(Produto model) {
		this.model = model;
	}
	
	public void setViewCadastro(AdminAdicionaProdutoNoEstoque viewAdiciona) {
		this.viewAdiciona = viewAdiciona;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == viewAdiciona.getBtnAdicionarProduto()) {
			
			int id = 0; 
			Integer unidadesEstoque = 0;
			
			
			try {
				id = Integer.parseInt(viewAdiciona.getTxtIdProduto().getText());
				unidadesEstoque = Integer.parseInt(viewAdiciona.getTxtUnidades().getText());

			} catch (Exception a) {
				a.getStackTrace();
			}
			
			
			String result = model.updateProduto(id, unidadesEstoque);
			
			viewAdiciona.setMensagem(result);
			System.out.println(result);
			
		}
		
	}
}
