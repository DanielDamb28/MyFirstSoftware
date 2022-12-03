package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import model.entities.Fornecedor;
import model.exceptions.CnpjNotNull;
import model.exceptions.CpfNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import model.exceptions.TelefoneNotNull;
import view.AdminFornecedorCadastro;

public class ControllerAdminFornecedorCadastro implements ActionListener{
	private Fornecedor model;
	private AdminFornecedorCadastro viewCadastro;
	
	public void setModel(Fornecedor model) {
		this.model = model;
	}
	
	public void setViewCadastro(AdminFornecedorCadastro viewCadastro) {
		this.viewCadastro = viewCadastro;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == viewCadastro.getBtnCadastrarFornecedor()) {
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate cadastro = null;
			
			String cnpj = "";
			String nome = "";
			String telefone = "-";
			String email = "-";
			String endereco = "-";
			String cep = "-";
			
			try {
				Instant dataCadastro = Instant.now();
				ZoneId zone = ZoneId.of("America/Edmonton");
				cadastro = LocalDate.ofInstant(dataCadastro, zone);
				
				cnpj = viewCadastro.getTxtCnpj().getText();
				nome = viewCadastro.getTxtNome().getText();
				endereco = viewCadastro.getEndereco();
				telefone = viewCadastro.getTxtTelefone().getText();
				email = viewCadastro.getTxtEmail().getText();
				cep = viewCadastro.getTxtCep().getText(); 
			} catch (Exception a) {
				a.getStackTrace();
			}
			Fornecedor fornecedor = null;
			
			try {
				fornecedor = new Fornecedor(nome, cep, endereco, telefone, email, cnpj);
			} catch (CnpjNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			} catch (NameNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			} catch (TelefoneNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			} catch (EmailNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			}
			
			
			String result = model.adicionaFornecedorNoBancoDeDados(fornecedor);
			
			System.out.println(result);
			
			if(result.equals("Cadastro efetuado com sucesso")) {
				viewCadastro.getMensagem().setForeground(Color.white);
				viewCadastro.getMensagem().setText(result);
			}
			else if(result.equals("Esse CPF/CNPJ já está cadastrado")) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(result);
			}
		}
		
	}
}