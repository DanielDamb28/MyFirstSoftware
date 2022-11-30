package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Produto {
	
	private static Conexao conexao = null;
	
	private String modelo;
	private String categoria;
	private String marca;
	private String setor;
	private String cor;
	private String tamanho;
	private Float preco;
	private	Integer unidadesEstoque;
	private String id;
	private Fornecedor fornecedor;
	
	public Produto() {}
	
	public Produto(String modelo, String categoria, String marca, String setor, String cor, String tamanho, Float preco,
			Integer unidadesEstoque, String id, Fornecedor fornecedor) {
		setModelo(modelo);
		setCategoria(categoria);
		setMarca(marca);
		setSetor(setor);
		setCor(cor);
		setTamanho(tamanho);
		setPreco(preco);
		setUnidadesEstoque(unidadesEstoque);
		setId(id);
		setFornecedor(fornecedor);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
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
