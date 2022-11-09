package conexaopostgree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import entities.Produto;

public class ConexaoProduto {
	
	private static Conexao conexao = null;
	
	public String adicionaProdutoNoBancoDeDados(Produto product) {
		
		String result = null;
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = enviaDados(product); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String enviaDados(Produto product) {
		int result = 0;
		String resposta = null;
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "INSERT INTO cliente(pk_id, modelo, categoria, marca, setor, cor, tamanho, preco, unidades_estoque, fk_fornecedor_cnpj)"
				+ " VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setString(1, product.getId());
			stmInsereClienteNoBancoDeDados.setString(2, product.getModelo());
			stmInsereClienteNoBancoDeDados.setString(3, product.getCategoria());
			stmInsereClienteNoBancoDeDados.setString(4, product.getMarca());
			stmInsereClienteNoBancoDeDados.setString(5, product.getSetor());
			stmInsereClienteNoBancoDeDados.setString(6, product.getCor());
			stmInsereClienteNoBancoDeDados.setString(7, product.getTamanho());
			stmInsereClienteNoBancoDeDados.setFloat(8, product.getPreco());
			stmInsereClienteNoBancoDeDados.setInt(9, product.getUnidadesEstoque());
			stmInsereClienteNoBancoDeDados.setString(10, String.valueOf(product.getFornecedor().getCNPJ()));
			
			result = stmInsereClienteNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
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
}
