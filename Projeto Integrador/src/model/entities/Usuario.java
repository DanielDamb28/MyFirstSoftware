package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private static Conexao conexao = null;
	
	private String id;
	private String senha;
	private String tipoAcesso;
	
	public Usuario() {}
	
	public Usuario(String id, String senha, String tipoAcesso) {
		setId(id);
		setSenha(senha);
		setTipoAcesso(tipoAcesso);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
	
	public String toString() {
		return "Produto \nId=" + id + " \nTipo de Acesso =" + tipoAcesso;
	}
	
	public String adicionaUsuarioNoBancoDeDados(Usuario user) {
		
		String result = null;
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = enviaDados(user); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String enviaDados(Usuario user) {
		int result = 0;
		String resposta = null;
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "INSERT INTO usuario(pk_id, senha, tipo_de_acesso)"
				+ " VALUES (?, ?, ?);";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setString(1, user.getId());
			stmInsereClienteNoBancoDeDados.setString(2, user.getSenha());
			stmInsereClienteNoBancoDeDados.setString(3, user.getTipoAcesso());
			
			result = stmInsereClienteNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 0;
			resposta = "Esse Id já está cadastrado";

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

	public String removeProdutoDoBancoDeDados(String id) {
		String result = null;
		conexao = new Conexao();
		
		result = removeDados(id);
		
		return result;
	}
	
	private String removeDados(String id) {
		int result = 0;
		String resposta = null;
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "DELETE FROM usuario WHERE pk_id = ?;";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setString(1, id);
			
			System.out.println(stmInsereFornecedorNoBancoDeDados);
			
			result = stmInsereFornecedorNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar usuario";

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
			return "Usuario excluido com sucesso";
		} else if(result == 0){
			return "id não encontrado";
		} else {
			return resposta;
		}
	}
	
	public String procuraDados(String id){
		int result = 0;
		String resposta = null;
		Usuario usuario = null;
		
		conexao = new Conexao();
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT * FROM usuario WHERE pk_id = ?;";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setString(1, id);
			
			System.out.println(stmInsereFornecedorNoBancoDeDados);
			
			ResultSet rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				
				usuario.setId(rs.getString("pk_id"));
				usuario.setTipoAcesso(rs.getString("tipo_de_acesso"));
				
				result = 1;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar usuario";

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
			return usuario.toString();
		} else if(result == 0){
			return "Id não encontrado";
		} else {
			return resposta;
		}
	}
	
	
	public List<Usuario> retornaUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		conexao = new Conexao();
		
		usuarios = getAllProdutos();
		
		return usuarios;
		
		
	}
	
	
	private List<Usuario> getAllProdutos(){
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT * FROM usuario;";
		ResultSet rs = null;
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(rs.getString("pk_id"));
				usuario.setTipoAcesso(rs.getString("tipo_de_acesso"));
				usuarios.add(usuario);
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
		return usuarios;
		
	}
}
