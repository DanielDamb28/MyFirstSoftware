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

public class Produto{
	
	private static Conexao conexao = null;
	
	private static int ids;
	
	private String modelo;
	private String categoria;
	private String marca;
	private String setor;
	private String cor;
	private String tamanho;
	private Float preco;
	private	Integer unidadesEstoque;
	private int id;
	private String fornecedor;
	
	public Produto() {
	}
	
	public Produto(String modelo, String categoria, String marca, String setor, String cor, String tamanho, Float preco,
			Integer unidadesEstoque, String fornecedorCnpj) {
		setModelo(modelo);
		setCategoria(categoria);
		setMarca(marca);
		setSetor(setor);
		setCor(cor);
		setTamanho(tamanho);
		setPreco(preco);
		setUnidadesEstoque(unidadesEstoque);
		novoId();
		setFornecedor(fornecedorCnpj);
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getUnidadesEstoque() {
		return unidadesEstoque;
	}

	public void setUnidadesEstoque(Integer unidadesEstoque) {
		this.unidadesEstoque = unidadesEstoque;
	}

	public int getId() {
		return id;
	}
	
	private void novoId() {
		ItemsSerializados item = new ItemsSerializados();
		this.id = ids;
		ids = ids + 1;
		Serializar s = new Serializar();
		item.setId(ids);
		try {
			s.serializar("./id.obj", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public String toString() {
		return "Produto \nId=" + id + " \nModelo=" + modelo + " \nCategoria=" + categoria + " \nMarca=" + marca
		+ " \nSetor=" + setor + "\nCor=" + cor + "\nTamanho= " + tamanho + "\nPreço= " + preco + "\nUnidades em estoque= " + unidadesEstoque + "\nFornecedor CNPJ= "+ fornecedor;
	}
	
	public String adicionaProdutoNoBancoDeDados(Produto product) {
		
		String result = null;
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = enviaDados(product); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String enviaDados(Produto product) {
		int result = 0;
		String resposta = null;
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "INSERT INTO produto(pk_id, modelo, categoria, marca, setor, cor, tamanho, preco, unidades_estoque, fk_fornecedor_cnpj)"
				+ " VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setInt(1, product.getId());
			stmInsereClienteNoBancoDeDados.setString(2, product.getModelo());
			stmInsereClienteNoBancoDeDados.setString(3, product.getCategoria());
			stmInsereClienteNoBancoDeDados.setString(4, product.getMarca());
			stmInsereClienteNoBancoDeDados.setString(5, product.getSetor());
			stmInsereClienteNoBancoDeDados.setString(6, product.getCor());
			stmInsereClienteNoBancoDeDados.setString(7, product.getTamanho());
			stmInsereClienteNoBancoDeDados.setFloat(8, product.getPreco());
			stmInsereClienteNoBancoDeDados.setInt(9, product.getUnidadesEstoque());
			stmInsereClienteNoBancoDeDados.setString(10, String.valueOf(product.getFornecedor()));
			
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

	public String removeProdutoDoBancoDeDados(int id) {
		String result = null;
		conexao = new Conexao();
		
		result = removeDados(id);
		
		return result;
	}
	
	private String removeDados(int id) {
		int result = 0;
		String resposta = null;
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "DELETE FROM produto WHERE pk_id = ?;";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setInt(1, id); /* <-------- ERRRO */
			
			System.out.println(stmInsereFornecedorNoBancoDeDados);
			
			result = stmInsereFornecedorNoBancoDeDados.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar produto";

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
			return "Produto excluido com sucesso";
		} else if(result == 0){
			return "id não encontrado";
		} else {
			return resposta;
		}
	}
	
	public String procuraDados(int id){
		int result = 0;
		String resposta = null;
		Produto produto = null;
		
		conexao = new Conexao();
		
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT * FROM produto WHERE pk_id = ?;";
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			stmInsereFornecedorNoBancoDeDados.setInt(1, id);
			
			System.out.println(stmInsereFornecedorNoBancoDeDados);
			
			ResultSet rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			if(rs.next()) {
				produto = new Produto();
				
				produto.setId(rs.getInt("pk_id"));
				produto.setModelo(rs.getString("modelo"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setMarca(rs.getString("marca"));
				produto.setSetor(rs.getString("setor"));
				produto.setCor(rs.getString("cor"));
				produto.setTamanho(rs.getString("tamanho"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setUnidadesEstoque(rs.getInt("unidades_estoque"));
				produto.setFornecedor(rs.getString("fk_fornecedor_cnpj"));
				
				result = 1;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			result = 2;
			resposta = "Erro ao procurar produto";

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
			return produto.toString();
		} else if(result == 0){
			return "Id não encontrado";
		} else {
			return resposta;
		}
	}
	
	
	public List<Produto> retornaProdutos(){
		List<Produto> fornecedores = new ArrayList<Produto>();
		conexao = new Conexao();
		
		fornecedores = getAllProdutos();
		
		return fornecedores;
		
		
	}
	
	
	private List<Produto> getAllProdutos(){
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "SELECT * FROM produto;";
		ResultSet rs = null;
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			while(rs.next()) {
				Produto produto = new Produto();

				produto.setId(rs.getInt("pk_id"));
				produto.setModelo(rs.getString("modelo"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setMarca(rs.getString("marca"));
				produto.setSetor(rs.getString("setor"));
				produto.setCor(rs.getString("cor"));
				produto.setTamanho(rs.getString("tamanho"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setUnidadesEstoque(rs.getInt("unidades_estoque"));
				produto.setFornecedor("fornecedor_cnpj");
				produtos.add(produto);
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
		return produtos;
		
	}
	

	public static int getIds() {
		return ids;
	}

	public static void setIds(int ids) {
		Produto.ids = ids;
	}
	
	

}
