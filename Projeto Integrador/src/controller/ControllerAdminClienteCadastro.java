package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import model.entities.Cliente;
import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import view.AdminClienteCadastro;
import view.AdminClienteMenu;

public class ControllerAdminClienteCadastro implements ActionListener{
	private Cliente model;
	private AdminClienteCadastro viewCadastro;
	
	public void setModel(Cliente model) {
		this.model = model;
	}
	
	public void setViewCadastro(AdminClienteCadastro viewCadastro) {
		this.viewCadastro = viewCadastro;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == viewCadastro.getBtnCadastrarCliente()) {
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate cadastro = null;
			
			String cpfCnpj = "";
			String nome = "";
			String endereco = "-";
			String telefone = "-";
			LocalDate dataNascimento = null;
			String cep = "-";
			String sexo = "";
			
			try {
				Instant dataCadastro = Instant.now();
				ZoneId zone = ZoneId.of("America/Edmonton");
				cadastro = LocalDate.ofInstant(dataCadastro, zone);
				
				cpfCnpj = viewCadastro.getTxtCpfCnpj().getText();
				nome = viewCadastro.getTxtNome().getText();
				endereco = viewCadastro.getEndereco();
				telefone = viewCadastro.getTxtTelefone().getText();
				dataNascimento = LocalDate.parse(viewCadastro.getTxtDataNasc().getText(), fmt);
				cep = viewCadastro.getTxtCep().getText();
				sexo = viewCadastro.getTxtSexo().getText();
			} catch (Exception a) {
				a.getStackTrace();
			}
			Cliente cliente = null;
			
			try {
				cliente = new Cliente(cpfCnpj, nome, endereco, telefone, dataNascimento, cadastro, cep, sexo);
			} catch (CpfNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			} catch (NameNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			} catch (SexoNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			} catch (NascimentoNotNull e) {
				viewCadastro.getMensagem().setForeground(Color.red);
				viewCadastro.getMensagem().setText(e.getMessage());
				e.printStackTrace();
			}
			
			String result = model.adicionaClienteNoBancoDeDados(cliente);
			
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
