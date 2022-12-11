package model.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ItensVendidos {
	
	private static Conexao conexao = null;
	
	private int produto;
	private int venda;
	private Integer numProdutos;
	private Float precoNaData;
	
	public ItensVendidos() {}

	public ItensVendidos(int produto, int venda, Integer numProdutos, Float precoNaData) {
		setProduto(produto);
		setVenda(venda);
		setNumProdutos(numProdutos);
		setPrecoNaData(precoNaData);
	}
	
public String adicionaVendaNoBancoDeDados(ItensVendidos item) {
		
		String result = null;
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = enviaDados(item); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String enviaDados(ItensVendidos item) {
		int result = 0;
		String resposta = null;
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "INSERT INTO itens_vendidos(fk_produto_id, fk_venda_id, numero_de_produtos, preco_na_data)"
				+ " VALUES (?, ?, ?, ?);";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setInt(1, item.getProduto());
			stmInsereClienteNoBancoDeDados.setInt(2, item.getVenda());
			stmInsereClienteNoBancoDeDados.setInt(3, item.getNumProdutos());
			stmInsereClienteNoBancoDeDados.setFloat(4, item.getPrecoNaData());
			
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

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getVenda() {
		return venda;
	}

	public void setVenda(int venda) {
		this.venda = venda;
	}

	public Integer getNumProdutos() {
		return numProdutos;
	}

	public void setNumProdutos(Integer numProdutos) {
		this.numProdutos = numProdutos;
	}

	public Float getPrecoNaData() {
		return precoNaData;
	}

	public void setPrecoNaData(Float precoNaData) {
		this.precoNaData = precoNaData;
	}
	
	
	
	
}
