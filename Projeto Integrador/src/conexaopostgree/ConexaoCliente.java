package conexaopostgree;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import entities.Cliente;
import entities.Usuario;

public class ConexaoCliente {
	
	private static Conexao conexao = null;
	
	public String adicionaClienteNoBancoDeDados(Cliente c) {
		String result = null;
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = enviaDados(c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public String enviaDados(Cliente cliente){
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
			resposta = "Esse CPF/CNPJ já está cadastrado";

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
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = removeDados(cpfCnpj);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public String removeDados(String cpfCnpj) {
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
	
}
