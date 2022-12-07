package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.exceptions.CnpjNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.TelefoneNotNull;
import model.factorys.FactoryException;

public class Fornecedor {
	
	private static Conexao conexao = null;
	
	private String nome;
	private String cep;
	private String endereco;
	private String telefone;
	private String email;
	private String cnpj;
	
	public Fornecedor () {}
	
	public Fornecedor(String nome, String cep, String endereco, String telefone, String email, String cnpj) throws CnpjNotNull, NameNotNull, EmailNotNull, TelefoneNotNull{
		setNome(nome);
		setCep(cep);
		setEndereco(endereco);
		setTelefone(telefone);
		setEmail(email);
		setCnpj(cnpj);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NameNotNull {
		if(!nome.isEmpty()) {
			this.nome = nome;
		} else {
			FactoryException.callNameNotNull();
		}
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	public void setTelefone(String telefone) throws TelefoneNotNull {
		if(!telefone.isEmpty()) {
			this.telefone = telefone;
		} else {
			FactoryException.callTelefoneNotNull();
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws EmailNotNull {
		if(!email.isEmpty()) {
			this.email = email;
		} else {
			FactoryException.callEmailNotNull();
		}
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) throws CnpjNotNull {
		if(!cnpj.isEmpty()) {
			this.cnpj = cnpj;
		} else {
			FactoryException.callCnpjNotNUll();
		}
	}
	
	public String toString() {
		return "Fornecedor \ncpfCnpj=" + cnpj + " \nnome=" + nome + " \nendereco=" + endereco + " \ntelefone=" + telefone
				+ " \nemail=" + email + "\ncep=" + cep ;
	}

	public String adicionaFornecedorNoBancoDeDados(Fornecedor f) {
		String result = null;
		conexao = new Conexao();
		System.out.println(f.getCnpj());
		result = enviaDados(f);
		
		return result;
	}
	
	private String enviaDados(Fornecedor fornecedor){
		int result = 0;
		String resposta = null;
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "INSERT INTO fornecedor(nome, cep, endereco, telefone, email, pk_cnpj)"
				+ " VALUES (?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setString(1, fornecedor.getNome());
			stmInsereFornecedorNoBancoDeDados.setString(2, fornecedor.getCep());
			stmInsereFornecedorNoBancoDeDados.setString(3, fornecedor.getEndereco());
			stmInsereFornecedorNoBancoDeDados.setString(4, fornecedor.getTelefone());
			stmInsereFornecedorNoBancoDeDados.setString(5, fornecedor.getEmail());
			stmInsereFornecedorNoBancoDeDados.setString(6, fornecedor.getCnpj());
			
			result = stmInsereFornecedorNoBancoDeDados.executeUpdate();
			
			
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
	
	public String removeFornecedorDoBancoDeDados(String cnpj) {
		String result = null;
		conexao = new Conexao();
		
		result = removeDados(cnpj);
		
		return result;
	}
	
	private String removeDados(String cnpj) {
		int result = 0;
		String resposta = null;
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "DELETE FROM fornecedor WHERE pk_cnpj = ?;";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setString(1, cnpj); /* <-------- ERRRO */
			
			System.out.println(stmInsereFornecedorNoBancoDeDados);
			
			result = stmInsereFornecedorNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar fornecedor";

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
			return "Fornecedor excluido com sucesso";
		} else if(result == 0){
			return "CPF/CNPJ não encontrado";
		} else {
			return resposta;
		}
	}
	
	public String procuraDados(String cnpj) throws NameNotNull, CnpjNotNull, TelefoneNotNull, EmailNotNull {
		int result = 0;
		String resposta = null;
		Fornecedor fornecedor = null;
		
		conexao = new Conexao();
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT * FROM fornecedor WHERE pk_cnpj = ?;";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setString(1, cnpj);
			
			System.out.println(stmInsereFornecedorNoBancoDeDados);
			
			ResultSet rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			if(rs.next()) {
				fornecedor = new Fornecedor();
				
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setCnpj(rs.getString("pk_cnpj"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setTelefone(rs.getString("telefone"));
				
				result = 1;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar fornecedor";

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
			return fornecedor.toString();
		} else if(result == 0){
			return "CNPJ não encontrado";
		} else {
			return resposta;
		}
	}
	
	
	public List<Fornecedor> retornaFornecedores() throws CnpjNotNull, NameNotNull, TelefoneNotNull, EmailNotNull {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		conexao = new Conexao();
		
		fornecedores = getAllFornecedores();
		
		return fornecedores;
		
		
	}
	
	private List<Fornecedor> getAllFornecedores() throws CnpjNotNull, NameNotNull, TelefoneNotNull, EmailNotNull{
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT * FROM fornecedor;";
		ResultSet rs = null;
		
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();

				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setCnpj(rs.getString("pk_cnpj"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setTelefone(rs.getString("telefone"));
				
				fornecedores.add(fornecedor);
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
		return fornecedores;
		
	}
	
	public List<String> retornaCnpjs(){
		List<String> fornecedores = new ArrayList<String>();
		conexao = new Conexao();
		
		fornecedores = getAllCnpjs();
		
		return fornecedores;
		
		
	}
	
	private List<String> getAllCnpjs(){
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT pk_cnpj FROM fornecedor;";
		ResultSet rs = null;
		
		ArrayList<String> fornecedores = new ArrayList<String>();
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			while(rs.next()) {
				
				fornecedores.add(rs.getString("pk_cnpj"));
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
		return fornecedores;
		
	}
}
