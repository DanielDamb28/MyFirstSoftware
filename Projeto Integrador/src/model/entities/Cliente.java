package model.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.exceptions.CpfNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.NascimentoNotNull;
import model.exceptions.SexoNotNull;
import model.factorys.FactoryException;

public class Cliente {
	
	private static Conexao conexao = null;
	
	private String cpfCnpj;
	private String nome;
	private String endereco;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataCadastro;
	private String cep;
	private char sexo;
	
	
	
	public Cliente() {}
	
	public Cliente(String cpfCnpj, String nome, String endereco, String telefone, LocalDate nascimento,
						LocalDate dataCadastro, String cep, String sexo) 
					throws CpfNotNull, NameNotNull, SexoNotNull, NascimentoNotNull{
		
		setCpfCnpj(cpfCnpj);
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		setDataNascimento(nascimento);
		setDataCadastro(dataCadastro);
		setCep(cep);
		setSexo(sexo);
	}
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpf) throws CpfNotNull{
		if(!cpf.isEmpty()) {
			this.cpfCnpj = cpf;
		} else {
			FactoryException.callCpfNotNull();
		}
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NameNotNull{
		if(!nome.isEmpty()) {
			this.nome = nome;
		} else {
			FactoryException.callNameNotNull();
		}
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) throws NascimentoNotNull {
		if(dataNascimento != null) {
			this.dataNascimento = dataNascimento;
		}else {
			FactoryException.callNascimentoNotNull();
		}
	}
	
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public void setSexo(String sexo) throws SexoNotNull{
		if(!sexo.isEmpty()) {
			this.sexo = sexo.charAt(0);
		}else {
			FactoryException.callSexoNotNull();
		}
	}
	
	
	
	public String toString() {
		return "Cliente \ncpfCnpj=" + cpfCnpj + " \nnome=" + nome + " \nendereco=" + endereco + " \ntelefone=" + telefone
				+ " \ndataNascimento=" + dataNascimento + " \ndataCadastro=" + dataCadastro + " \ncep=" + cep + " \nsexo="
				+ sexo;
	}

	public String adicionaClienteNoBancoDeDados(Cliente c) {
		String result = null;
		conexao = new Conexao();
		
		result = enviaDados(c);
		
		return result;
		
		
	}
	
	private String enviaDados(Cliente cliente){
		int result = 0;
		String resposta = null;
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "INSERT INTO cliente(pk_cpf_cnpj, nome, endereco, telefone, data_nascimento, data_cadastro, cep, sexo)"
				+ " VALUES (?, ?, ?, ? , ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setString(1, cliente.getCpfCnpj());
			stmInsereClienteNoBancoDeDados.setString(2, cliente.getNome());
			stmInsereClienteNoBancoDeDados.setString(3, cliente.getEndereco());
			stmInsereClienteNoBancoDeDados.setString(4, cliente.getTelefone());
			stmInsereClienteNoBancoDeDados.setDate(5, Date.valueOf(cliente.getDataNascimento()));
			stmInsereClienteNoBancoDeDados.setDate(6, Date.valueOf(cliente.getDataCadastro()));
			stmInsereClienteNoBancoDeDados.setString(7, cliente.getCep());
			stmInsereClienteNoBancoDeDados.setString(8, String.valueOf(cliente.getSexo()));
			
			result = stmInsereClienteNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
			result = 0;
			resposta = e.getMessage();

		}finally{
			if(con != null){
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					resposta = "Erro ao encerrar conexao";
					e.getStackTrace();
				}
			}
		}
		
		if(result == 1) {
			return "Cadastro efetuado com sucesso";
		} else {
			return resposta;
		}
	}
	
	
	
	public String removeClienteDoBancoDeDados(String cpfCnpj) {
		String result = null;
		conexao = new Conexao();
		
		result = removeDados(cpfCnpj);
		
		return result;
		
		
	}
	
	private String removeDados(String cpfCnpj) {
		int result = 0;
		String resposta = null;
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "DELETE FROM cliente WHERE pk_cpf_Cnpj = ?;";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setString(1, cpfCnpj);
			
			System.out.println(stmInsereClienteNoBancoDeDados);
			
			result = stmInsereClienteNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar cliente";

		}finally{
			if(con != null){
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					result = 2;
					resposta = "Erro ao encerrar conexao";
					e.getStackTrace();
				}
			}
		}
		
		if(result == 1) {
			return "Cliente excluido com sucesso";
		} else if(result == 0){
			return "CPF/CNPJ não encontrado";
		} else {
			return resposta;
		}
	}
	
	public String procuraDados(String cpfCnpj) throws NameNotNull, CpfNotNull, NascimentoNotNull, SexoNotNull {
		int result = 0;
		String resposta = null;
		Cliente cliente = null;
		
		conexao = new Conexao();
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "SELECT * FROM cliente WHERE pk_cpf_Cnpj = ?;";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setString(1, cpfCnpj);
			
			System.out.println(stmInsereClienteNoBancoDeDados);
			
			ResultSet rs = stmInsereClienteNoBancoDeDados.executeQuery();
			if(rs.next()) {
				cliente = new Cliente();
				
				cliente.setNome(rs.getString("nome"));
				cliente.setDataCadastro(rs.getDate("Data_Cadastro").toLocalDate());
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCpfCnpj(rs.getString("pk_cpf_cnpj"));
				cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCep(rs.getString("cep"));
				cliente.setSexo(rs.getString("sexo"));
				
				result = 1;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar cliente";

		}finally{
			if(con != null){
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					result = 2;
					resposta = "Erro ao encerrar conexao";
					e.getStackTrace();
				}
			}
		}
		
		if(result == 1) {
			return cliente.toString();
		} else if(result == 0){
			return "CPF/CNPJ não encontrado";
		} else {
			return resposta;
		}
	}
	
	
	public List<Cliente> retornaClientes() throws CpfNotNull, NameNotNull, SexoNotNull, NascimentoNotNull {
		List<Cliente> clientes = new ArrayList<Cliente>();
		conexao = new Conexao();
		
		
		clientes = getAllClientes();
		
		return clientes;
		
		
	}
	
	private List<Cliente> getAllClientes() throws CpfNotNull, NameNotNull, SexoNotNull, NascimentoNotNull{
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "SELECT * FROM cliente;";
		ResultSet rs = null;
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			rs = stmInsereClienteNoBancoDeDados.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCpfCnpj(rs.getString("pk_cpf_cnpj"));
				cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCep(rs.getString("cep"));
				cliente.setSexo(rs.getString("sexo"));
				
				clientes.add(cliente);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					e.getStackTrace();
				}
			}
		}
		return clientes;
		
	}
}
