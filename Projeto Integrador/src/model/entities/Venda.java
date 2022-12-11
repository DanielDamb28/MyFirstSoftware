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

import model.exceptions.CategoriaNotNull;
import model.exceptions.CorNotNull;
import model.exceptions.MarcaNotNull;
import model.exceptions.ModeloNotNull;
import model.exceptions.PrecoNotNull;
import model.exceptions.SetorNotNull;
import model.exceptions.TamanhoNotNull;
import model.exceptions.UnidadeNotNull;

public class Venda {
	
	private static Conexao conexao = null;
	
	private static Usuario usuarioX;
	private static int ids;
	
	private int id;
	private LocalDate data;
	private Float precoTotal;
	private String tipoVenda;
	private String cliente;
	private Usuario usuario;
	
	public Venda() {}
	
	public Venda(LocalDate data, Float precoTotal, String tipoVenda, String cliente) {
		novoId();
		setData(data);
		setPrecoTotal(precoTotal);
		setTipoVenda(tipoVenda);
		setCliente(cliente);
		setUsuario();
	}
	
	public String adicionaVendaNoBancoDeDados(Venda venda) {
		
		String result = null;
		try {
			conexao = new Conexao();
			
			System.out.println("Usuario da Conexao: " + conexao.getConexao().getMetaData().getUserName());
			System.out.println("URL da Conexao: " + conexao.getConexao().getMetaData().getURL());
			
			result = enviaDados(venda); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String enviaDados(Venda venda) {
		int result = 0;
		String resposta = null;
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Connection con = conexao.getConexao();
		String comandoInsereClienteNoBancoDeDados = "INSERT INTO venda(pk_id, data, tipo_de_venda, fk_cliente_cpf_cnpj, fk_usuario, preco_total)"
				+ " VALUES (?, ?, ?, ? , ?, ?);";
		
		try {
			PreparedStatement stmInsereClienteNoBancoDeDados = con.prepareStatement(comandoInsereClienteNoBancoDeDados);
			
			stmInsereClienteNoBancoDeDados.setInt(1, venda.getId());
			stmInsereClienteNoBancoDeDados.setDate(5, Date.valueOf(venda.getData()));
			stmInsereClienteNoBancoDeDados.setString(3, venda.getTipoVenda());
			stmInsereClienteNoBancoDeDados.setString(4, venda.getCliente());
			stmInsereClienteNoBancoDeDados.setString(5, venda.getUsuario().getId());
			stmInsereClienteNoBancoDeDados.setFloat(6, venda.getPrecoTotal());
			
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
	
	public Produto procuraDados(int id) throws Exception{
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
			return produto;
		} else {
			throw new Exception();
		}
	}
	
	public List<Produto> retornaProdutos() throws ModeloNotNull, CategoriaNotNull, MarcaNotNull, SetorNotNull, CorNotNull, TamanhoNotNull, PrecoNotNull, UnidadeNotNull{
		List<Produto> fornecedores = new ArrayList<Produto>();
		conexao = new Conexao();
		
		fornecedores = getAllProdutos();
		
		return fornecedores;
		
		
	}
	
	
	private List<Produto> getAllProdutos() throws ModeloNotNull, CategoriaNotNull, MarcaNotNull, SetorNotNull, CorNotNull, TamanhoNotNull, PrecoNotNull, UnidadeNotNull{
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

	public int getId() {
		return id;
	}

	public void setId(int ids) {
		id = ids;
	}
	
	public void novoId() {
		ItemsSerializados item = new ItemsSerializados();
		this.id = ids;
		ids = ids + 1;
		Serializar s = new Serializar();
		item.setIdVenda(ids);
		try {
			s.serializar("./id.obj", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda(String tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public static void setUsuarioX(Usuario user) {
		usuarioX = user;
	}

	public void setUsuario() {
		usuario = usuarioX;
	}

	public static int getIds() {
		return ids;
	}

	public static void setIds(int ids) {
		Venda.ids = ids;
	}
	
	
}
