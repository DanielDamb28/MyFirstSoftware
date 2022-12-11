 package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
