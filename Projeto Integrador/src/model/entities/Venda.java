package model.entities;

import java.time.LocalDate;

public class Venda {
	private String id;
	private LocalDate data;
	private Float precoTotal;
	private String tipoVenda;
	private Cliente cliente;
	private Usuario usuario;
	
	public Venda() {}
	
	public Venda(String id, LocalDate data, Float precoTotal, String tipoVenda, Cliente cliente, Usuario usuario) {
		setId(id);
		setData(data);
		setPrecoTotal(precoTotal);
		setTipoVenda(tipoVenda);
		setCliente(cliente);
		setUsuario(usuario);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
