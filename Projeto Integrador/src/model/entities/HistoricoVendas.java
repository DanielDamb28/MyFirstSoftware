package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.exceptions.CnpjNotNull;
import model.exceptions.EmailNotNull;
import model.exceptions.NameNotNull;
import model.exceptions.TelefoneNotNull;

public class HistoricoVendas {
	
	private static Conexao conexao = null;
	
	private int venda_id;
	private float preco_total;
	private String cliente;
	private String usuario;
	private int num_produtos;
	private LocalDate data;
	
	public HistoricoVendas(){}
	
	public HistoricoVendas(int venda_id, float preco_total, String cliente, String usuario, int num_produtos,
			LocalDate data) {
		super();
		this.venda_id = venda_id;
		this.preco_total = preco_total;
		this.cliente = cliente;
		this.usuario = usuario;
		this.num_produtos = num_produtos;
		this.data = data;
	}
	
	public List<HistoricoVendas> retornaHistorico(){
		List<HistoricoVendas> vendas = new ArrayList<HistoricoVendas>();
		conexao = new Conexao();
		
		vendas = getAllHistorico();
		
		return vendas;
		
		
	}

	public List<HistoricoVendas> getAllHistorico(){
		Connection con = conexao.getConexao();
		String comandoInsereFornecedorNoBancoDeDados = "select vd.pk_id, vd.preco_total, vd.fk_cliente_cpf_cnpj, vd.fk_usuario_id, vd.data, sum(numero_de_produtos) as numero_de_produtos from itens_vendidos as iv inner join produto as pd on iv.fk_produto_id = pd.pk_id inner join venda as vd on iv.fk_venda_id = vd.pk_id group by vd.pk_id, iv.numero_de_produtos;";
		ResultSet rs = null;
		
		ArrayList<HistoricoVendas> vendas = new ArrayList<HistoricoVendas>();
		
		try {
			PreparedStatement stmInsereFornecedorNoBancoDeDados = con.prepareStatement(comandoInsereFornecedorNoBancoDeDados);
			
			rs = stmInsereFornecedorNoBancoDeDados.executeQuery();
			while(rs.next()) {
				HistoricoVendas historico = new HistoricoVendas();
				historico.setNum_produtos(rs.getInt("numero_de_produtos"));
				historico.setVenda_id(rs.getInt("pk_id"));
				historico.setCliente(rs.getString("fk_cliente_cpf_cnpj"));
				historico.setUsuario(rs.getString("fk_usuario_id"));
				historico.setData(rs.getDate("data").toLocalDate());
				historico.setPreco_total(rs.getFloat("preco_total"));
				
				vendas.add(historico);
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
		return vendas;
		
	}

	public int getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(int venda_id) {
		this.venda_id = venda_id;
	}
	public float getPreco_total() {
		return preco_total;
	}
	public void setPreco_total(float preco_total) {
		this.preco_total = preco_total;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getNum_produtos() {
		return num_produtos;
	}
	public void setNum_produtos(int num_produtos) {
		this.num_produtos = num_produtos;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
