 package model.entities;

import java.time.LocalDate;

public class Venda {
	
	private static Usuario usuario;
	private static int ids;
	
	private int id;
	private LocalDate data;
	private Float precoTotal;
	private String tipoVenda;
	private Cliente cliente;
	
	public Venda() {}
	
	public Venda(String id, LocalDate data, Float precoTotal, String tipoVenda, Cliente cliente, Usuario usuario) {
		novoId();
		setData(data);
		setPrecoTotal(precoTotal);
		setTipoVenda(tipoVenda);
		setCliente(cliente);
		setUsuario(usuario);
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario user) {
		usuario = user;
	}

	public static int getIds() {
		return ids;
	}

	public static void setIds(int ids) {
		Venda.ids = ids;
	}
	
	
}
